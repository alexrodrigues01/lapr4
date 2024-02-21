package gramaticas.script;

import eapli.base.servicomanagement.domain.FormularioP;

import java.util.HashMap;
import java.util.Map;

public class GramaticaScriptVisitorImplement extends GramaticaScriptBaseVisitor<String> {
    Map<String,String> values= new HashMap<>();
    FormularioP formularioP = new FormularioP();
    private String ficheiro;

    boolean interpretacao;


    public GramaticaScriptVisitorImplement(boolean interpretacao) {
        this.interpretacao = interpretacao;
    }

    public void setFormularioP(FormularioP formularioP) {
        this.formularioP = formularioP;
    }

    @Override
    public String visitConsultar(GramaticaScriptParser.ConsultarContext ctx) {
        if(interpretacao) {
            ficheiro = ctx.varFicheiro.getText();
            return visit(ctx.opcoesFicheiro());
        }else {
            return super.visitConsultar(ctx);
        }
    }

    @Override
    public String visitAtualizarFile(GramaticaScriptParser.AtualizarFileContext ctx) {
        if(interpretacao) {
            String id = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
            String parametro = formularioP.atributos().get(Integer.parseInt(ctx.idVar2.getText()) - 1).resposta().resposta();
            XMLUpdater.update(ficheiro, id, ctx.parametroVar.getText(), parametro);
            return "0";
        }else {
            return super.visitAtualizarFile(ctx);
        }
    }

    @Override
    public String visitConsultarFile(GramaticaScriptParser.ConsultarFileContext ctx) {
        if(interpretacao) {
            String id = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
            return XMLParser.xmlPaser(id, ctx.parametroVar.getText(), ficheiro);
        }else {
            return super.visitConsultarFile(ctx);
        }
    }

    @Override
    public String visitAtribuirOp(GramaticaScriptParser.AtribuirOpContext ctx) {
        return ""+values.get(ctx.fulltext().getText());
    }

    @Override
    public String visitAtribuir(GramaticaScriptParser.AtribuirContext ctx) {
        if(!values.containsKey(ctx.fulltext().getText())){
            values.put(ctx.fulltext().getText(),visit(ctx.atribuirOpcoes()));
        }else{
            values.replace(ctx.fulltext().getText(),visit(ctx.atribuirOpcoes()));
        }
        return "1";
    }

    @Override
    public String visitTextoOpcao(GramaticaScriptParser.TextoOpcaoContext ctx) {
        if(interpretacao) {
            return ctx.WORD().getText();
        }else {
            return super.visitTextoOpcao(ctx);
        }
    }

    @Override
    public String visitNumberFile(GramaticaScriptParser.NumberFileContext ctx) {
        if(interpretacao) {
            String id = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
            return XMLParser.xmlPaser(id, ctx.parametroVar.getText(), ctx.varFicheiro.getText());
        }else {
            return super.visitNumberFile(ctx);
        }
    }


    @Override
    public String visitSe(GramaticaScriptParser.SeContext ctx) {
        if(interpretacao) {
            String operador = ctx.verificarCondicao().operadores().getText();

            if (operador.equalsIgnoreCase("-MESMO")) {
                if (visit(ctx.verificarCondicao().opcoes(0)).equalsIgnoreCase(visit(ctx.verificarCondicao().opcoes(1)))) {
                    visit(ctx.funcionalidade());
                    return "true";
                }
                return "false";
            }

            double left = Double.parseDouble(visit(ctx.verificarCondicao().opcoes(0)));
            double right = Double.parseDouble(visit(ctx.verificarCondicao().opcoes(1)));
            if (operador.equalsIgnoreCase("-MAIOR")) {
                if (left > right) {
                    visitFuncionalidade(ctx.funcionalidade());
                }
            } else if (operador.equalsIgnoreCase("-MENOR")) {
                if (left < right) {
                    visitFuncionalidade(ctx.funcionalidade());
                }
            } else if (operador.equalsIgnoreCase("-IGUAL")) {
                if (left == right) {
                    visitFuncionalidade(ctx.funcionalidade());
                }
            }
            return "0";
        }else {
            return super.visitSe(ctx);
        }
    }

    @Override
    public String visitAdquirir(GramaticaScriptParser.AdquirirContext ctx) {
        if(interpretacao) {
            return visit(ctx.adquirirOpcoes());
        }else {
            return super.visitAdquirir(ctx);
        }
    }

    @Override
    public String visitCalculo(GramaticaScriptParser.CalculoContext ctx) {
        if(interpretacao) {
            double value = 0;

            double left = Double.parseDouble(visit(ctx.operacao().opcoes(0)));
            double right = Double.parseDouble(visit(ctx.operacao().opcoes(1)));
            if (ctx.op.getText().equalsIgnoreCase("-SUM")) {
                value = left + right;
            } else if (ctx.op.getText().equalsIgnoreCase("-SUB")) {

                value = left - right;
            } else if (ctx.op.getText().equalsIgnoreCase("-DIV")) {

                value = left / right;
            } else if (ctx.op.getText().equalsIgnoreCase("-MUL")) {

                value = left * right;
            }
            return "" + value;
        }else {
            return super.visitCalculo(ctx);
        }
    }

    @Override
    public String visitAtualizarSomaFile(GramaticaScriptParser.AtualizarSomaFileContext ctx) {
        if(interpretacao) {
            XMLUpdater.updateSoma(ficheiro, ctx.parametroVar.getText(), ctx.fulltext().getText(), ctx.parametroVar2.getText(), Integer.parseInt(ctx.INT().getText()));
            return "1";
        }else {
            return super.visitAtualizarSomaFile(ctx);
        }
    }

    @Override
    public String visitEmail(GramaticaScriptParser.EmailContext ctx) {
        if(interpretacao) {
            String alvo = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();

        Emails.sendEmail(ctx.varEmail.getText(),ctx.varPassword.getText(),"No-Reply",alvo,ctx.varAssunto.getText(),TextFormat.formatarTexto(visit(ctx.corpo())));
            return "1";
        }else {
            return super.visitEmail(ctx);
        }
    }

    @Override
    public String visitBlank(GramaticaScriptParser.BlankContext ctx) {
        if(interpretacao) {
            return "";
        }else {
            return super.visitBlank(ctx);
        }
    }

    @Override
    public String visitTexto(GramaticaScriptParser.TextoContext ctx) {
        if(interpretacao) {
            return ctx.fulltext().getText() + visit(ctx.corpo());
        }else {
            return super.visitTexto(ctx);
        }
    }

    @Override
    public String visitOpcoesAdquirir(GramaticaScriptParser.OpcoesAdquirirContext ctx) {
        if(interpretacao) {
            return " " + visit(ctx.adquirir()) + " " + visit(ctx.corpo());
        }else {
            return super.visitOpcoesAdquirir(ctx);
        }
    }

    @Override
    public String visitAtributoForm(GramaticaScriptParser.AtributoFormContext ctx) {
        if(interpretacao) {

            return formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
        }else {
            return super.visitAtributoForm(ctx);
        }
    }

    @Override
    public String visitInteiro(GramaticaScriptParser.InteiroContext ctx) {
        if(interpretacao) {
            return ctx.getText();
        }else {
            return super.visitInteiro(ctx);
        }
    }

}
