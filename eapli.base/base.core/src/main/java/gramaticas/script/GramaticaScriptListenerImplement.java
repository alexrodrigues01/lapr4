package gramaticas.script;

import eapli.base.servicomanagement.domain.FormularioP;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GramaticaScriptListenerImplement extends GramaticaScriptBaseListener {
    Stack<String> stack;
    boolean bool = true;
    boolean value = true;
    boolean interpretacao;
    Map<String, String> values = new HashMap<>();

    public GramaticaScriptListenerImplement(boolean interpretacao) {
        this.stack = new Stack<>();
        this.interpretacao = interpretacao;
    }

    @Override
    public void enterConsultar(GramaticaScriptParser.ConsultarContext ctx) {
        if (interpretacao) {
            stack.push(ctx.varFicheiro.getText());
        } else {
            super.enterConsultar(ctx);
        }

    }


    @Override
    public void exitFulltext(GramaticaScriptParser.FulltextContext ctx) {
        if (interpretacao) {
            if (value)
                stack.push(ctx.getText());
        } else {
            super.exitFulltext(ctx);
        }
    }


    @Override
    public void exitConsultarFile(GramaticaScriptParser.ConsultarFileContext ctx) {
        if (interpretacao) {
            if (bool) {
                String id = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
                stack.push(" " + XMLParser.xmlPaser(id, ctx.parametroVar.getText(), stack.pop()));
            }
        } else {
            super.exitConsultarFile(ctx);
        }
    }

    @Override
    public void exitAtualizarFile(GramaticaScriptParser.AtualizarFileContext ctx) {
        if (interpretacao) {
            if (bool) {
                String id = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
                String parametro = formularioP.atributos().get(Integer.parseInt(ctx.idVar2.getText()) - 1).resposta().resposta();
                XMLUpdater.update(stack.pop(), id, ctx.parametroVar.getText(), parametro);
            }
        } else {
            super.exitAtualizarFile(ctx);
        }
    }

    @Override
    public void exitAtualizarSomaFile(GramaticaScriptParser.AtualizarSomaFileContext ctx) {
        if (interpretacao) {
            if (bool) {
                String parametro = stack.pop();
                XMLUpdater.updateSoma(stack.pop(), ctx.parametroVar.getText(), parametro, ctx.parametroVar2.getText(), Integer.parseInt(ctx.INT().getText()));
            }
        } else {
            super.exitAtualizarSomaFile(ctx);
        }
    }

    @Override
    public void enterNumberFile(GramaticaScriptParser.NumberFileContext ctx) {
        if (interpretacao) {
            if (bool) {
                String id = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
                stack.push(" " + XMLParser.xmlPaser(id, ctx.parametroVar.getText(), ctx.varFicheiro.getText()));
            }
        } else {
            super.enterNumberFile(ctx);
        }
    }

    @Override
    public void exitEmail(GramaticaScriptParser.EmailContext ctx) {
        if (interpretacao) {
            if (bool) {
                String alvo = formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta();
                StringBuilder construct = new StringBuilder();
                String phrase;
                while (!(phrase = stack.pop()).equalsIgnoreCase("EMAIL_END")) {
                    if (!phrase.equals(ctx.varPassword.getText()) && !phrase.equals(ctx.varAssunto.getText()))
                        construct.insert(0, phrase);
                }
                Emails.sendEmail(ctx.varEmail.getText(), ctx.varPassword.getText(), "No-Reply", alvo, ctx.varAssunto.getText(), construct.toString());
            }
        } else {
            super.exitEmail(ctx);
        }
    }

    @Override
    public void enterEmail(GramaticaScriptParser.EmailContext ctx) {
        if (interpretacao) {
            if (bool) {
                stack.push("EMAIL_END");
            }
        } else {
            super.enterEmail(ctx);
        }
    }

    @Override
    public void enterInteiro(GramaticaScriptParser.InteiroContext ctx) {
        if (interpretacao) {
            if (bool)
                stack.push(" " + ctx.getText());
        } else {
            super.enterInteiro(ctx);
        }
    }


    @Override
    public void exitAtributoForm(GramaticaScriptParser.AtributoFormContext ctx) {
        if (interpretacao) {
            if (bool)
                stack.push(formularioP.atributos().get(Integer.parseInt(ctx.idVar.getText()) - 1).resposta().resposta());
        } else {
            super.exitAtributoForm(ctx);
        }
    }

    @Override
    public void exitCalculo(GramaticaScriptParser.CalculoContext ctx) {
        if (interpretacao) {
            double value = 0;
            double right = Double.parseDouble(stack.pop());
            double left = Double.parseDouble(stack.pop());

            if (bool) {
                if (ctx.op.getText().equalsIgnoreCase("-SUM")) {
                    value = left + right;
                } else if (ctx.op.getText().equalsIgnoreCase("-SUB")) {
                    value = left - right;
                } else if (ctx.op.getText().equalsIgnoreCase("-DIV")) {
                    value = left / right;
                } else if (ctx.op.getText().equalsIgnoreCase("-MUL")) {
                    value = left * right;
                }
                stack.push(value + "");
            }
        } else {
            super.exitCalculo(ctx);
        }
    }

    @Override
    public void exitAtribuir(GramaticaScriptParser.AtribuirContext ctx) {
        if (bool) {
            if (!values.containsKey(ctx.fulltext().getText())) {
                values.put(ctx.fulltext().getText(), stack.pop());
            } else {
                values.replace(ctx.fulltext().getText(), stack.pop());
            }
        }
    }

    @Override
    public void enterAtribuirOp(GramaticaScriptParser.AtribuirOpContext ctx) {
        if (bool) {
            value = false;
            stack.push("" + values.get(ctx.fulltext().getText()));
        }
    }

    @Override
    public void exitAtribuirOp(GramaticaScriptParser.AtribuirOpContext ctx) {
        if (bool) {
            value = true;
        }
    }

    @Override
    public void exitVerificarCondicao(GramaticaScriptParser.VerificarCondicaoContext ctx) {
        if (interpretacao) {
            String operador = ctx.operadores().getText();
            if (operador.equalsIgnoreCase("-MESMO")) {
                if (stack.pop().equalsIgnoreCase(stack.pop())) {
                    bool = true;
                    return;
                } else {
                    bool = false;
                    return;
                }
            }
            double right = Double.parseDouble(stack.pop());
            double left = Double.parseDouble(stack.pop());
            if (operador.equalsIgnoreCase("-MAIOR")) {
                if (left > right) {
                    bool = true;
                } else {
                    bool = false;
                }
            } else if (operador.equalsIgnoreCase("-MENOR")) {
                if (left < right) {
                    bool = true;
                } else {
                    bool = false;
                }
            } else if (operador.equalsIgnoreCase("-IGUAL")) {
                if (left == right) {
                    bool = true;
                } else {
                    bool = false;
                }
            }
        } else {
            super.exitVerificarCondicao(ctx);
        }
    }


    @Override
    public void exitSe(GramaticaScriptParser.SeContext ctx) {
        if (interpretacao) {
            bool = true;
        } else {
            super.exitSe(ctx);
        }
    }

    @Override
    public void enterTextoOpcao(GramaticaScriptParser.TextoOpcaoContext ctx) {
        if (interpretacao) {
            if (bool)
                stack.push(ctx.WORD().getText());
        } else {
            super.enterTextoOpcao(ctx);
        }
    }

    FormularioP formularioP = new FormularioP();


    public void setFormularioP(FormularioP formularioP) {
        this.formularioP = formularioP;
    }

}
