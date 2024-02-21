package gramaticas.formulario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioListenerImplement extends FormularioGrammarBaseListener{
    Stack<String> stack = new Stack<>();

    private String resultado = "OK";
    private int erros = 0;

    private String atributoUnico;

    private int num = Integer.MAX_VALUE;
    private double unico = Double.MAX_VALUE;

    private boolean flagObrigatoriedade = false;
    private int index = 0;

    private boolean flagExpressaoRegular = false;
    private int indexExp = 0;
    private String expressaoRegularAlterada = "";

    @Override
    public void enterLinha(FormularioGrammarParser.LinhaContext ctx) {
        String nome = ctx.nome.getText();
        String resposta = ctx.resposta.getText();
        String tipo = ctx.tipo.getText();
        String expressaoRegular = ctx.expressaoRegular.getText();
        String obrigatoriedade = ctx.obrigatoriedade.getText();

        index--;
        if (flagObrigatoriedade && index == 0) {
            obrigatoriedade = "true";
            flagObrigatoriedade = false;
        }
        indexExp--;
        if (flagExpressaoRegular && indexExp == 0) {
            expressaoRegular = expressaoRegularAlterada;
            flagExpressaoRegular = false;
        }

        if ((!resposta.isBlank() || !resposta.isEmpty())) {

            flagExpressaoRegularDelay(nome, resposta);

            if (tipo.equalsIgnoreCase("Inteiro") || tipo.equalsIgnoreCase("Soma") || tipo.equalsIgnoreCase("Subtracao") || tipo.equalsIgnoreCase("Igual") || tipo.equalsIgnoreCase("InteiroUnico")) {
                verificacaoNumericos(nome, expressaoRegular, resposta, tipo);
            } else if (tipo.equalsIgnoreCase("Boolean")) {
                verificacaoBoolean(nome, tipo, resposta);
            } else if (tipo.equalsIgnoreCase("Periodo")) {
                verificacaoPeriodo(nome, tipo, resposta);
            } else if (tipo.equalsIgnoreCase("String") || tipo.equalsIgnoreCase("Multipla")) {
                checkExpressaoRegular(resposta, expressaoRegular);
            } else if (tipo.equalsIgnoreCase("Data")) {
                verificacaoData(nome, expressaoRegular, tipo, resposta);
            } else if(tipo.equalsIgnoreCase("Ficheiro")){
                checkExpressaoRegular(resposta, expressaoRegular);
            }
        }

        if (obrigatoriedade.equalsIgnoreCase("true") && (resposta.isBlank() || resposta.isEmpty())) {
            erroRespostaObrigatoria(nome);
        }
    }

    private void flagExpressaoRegularDelay(String nome, String resposta){
        if (nome.equalsIgnoreCase("Codigo Produto") && ( resposta.startsWith("20") || resposta.startsWith("21") ) ) {
            flagExpressaoRegular = true;
            indexExp = 1;
            expressaoRegularAlterada = "[0-9]+[.,][1-9][0-9]+";
        }
    }

    private void verificacaoNumericos(String nome, String expressaoRegular, String resposta, String tipo){
        try {
            double valor = Double.parseDouble(resposta);
            checkExpressaoRegular(resposta, expressaoRegular);
            if (tipo.equalsIgnoreCase("Soma")) {
                if (num == Integer.MAX_VALUE) {
                    num = 0;
                }
                num += valor;

            }else if (tipo.equalsIgnoreCase("Subtracao")){
                if (num == Integer.MAX_VALUE) {
                    num = 0;
                }
                num -= valor;

            } else if (tipo.equalsIgnoreCase("Igual")) {
                if (num != valor) {
                    erros++;
                    resultado = "NotOK";
                    System.out.println("ERRO #" + erros + " : Resposta '" + nome + "' não está de acordo com os valores anteriores.");
                }
                num = Integer.MAX_VALUE;
            }

            if (tipo.equalsIgnoreCase("InteiroUnico")) {
                if (unico == Double.MAX_VALUE) {
                    unico = valor;
                    atributoUnico = nome;
                } else {
                    erros++;
                    resultado = "NotOK";
                    System.out.println("ERRO #" + erros + " : O atributo '" + nome + "' não pode ter resposta pois o atributo '" + atributoUnico + "' já foi preenchido");
                }
            }

        } catch (NumberFormatException nfe) {
            erroTipoDados(resposta, nome, tipo);
        }
    }

    private void verificacaoBoolean(String nome, String tipo, String resposta){
        if (!resposta.equalsIgnoreCase("true") && !resposta.equalsIgnoreCase("false")) {
            erroTipoDados(resposta, nome, tipo);
        }
    }

    private void verificacaoPeriodo(String nome, String tipo, String resposta){
        String[] parts = resposta.split("\\.");
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(parts[0]);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(parts[1]);
            if (date2.before(date1)) {
                erros++;
                resultado = "NotOK";
                System.out.println("ERRO #" + erros + " : Resposta '" + resposta + "' a '" + nome + "' não está correta, a data final não pode ser anterior à inicial.");
            }
        } catch (ParseException e) {
            erroTipoDados(resposta, nome, tipo);
        }
    }

    private void verificacaoData(String nome, String expressaoRegular, String tipo, String resposta){
        checkExpressaoRegular(resposta, expressaoRegular);
        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(resposta);
        } catch (ParseException e) {
            erroTipoDados(resposta, nome, tipo);
        }
    }

    private void erroTipoDados(String resposta, String nome, String tipo){
        erros++;
        resultado = "NotOK";
        System.out.println("ERRO #" + erros + " : Resposta '" + resposta + "' a '" + nome + "' não está de acordo com o tipo de dados " + tipo + ".");
    }

    private void erroRespostaObrigatoria(String nome){
        erros++;
        resultado = "NotOK";
        System.out.println("ERRO #" + erros + " : Resposta a '" + nome + "' tem que ser obrigatória.");
    }

    private void checkExpressaoRegular(String resposta, String expressaoRegular) {
        if (!expressaoRegular.isEmpty() || !expressaoRegular.isBlank()) {
            Pattern pattern = Pattern.compile(expressaoRegular, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(resposta);

            if (!matcher.find()) {
                erros++;
                resultado = "NotOK";
                System.out.println("ERRO #" + erros + " : Resposta '" + resposta + "' não está de acordo com a expressão regular " + expressaoRegular + ".");
            }
        }
    }

    @Override
    public void enterMudarObrigatoriedade(FormularioGrammarParser.MudarObrigatoriedadeContext ctx) {
        String resposta = ctx.getText();

        if (resposta.equalsIgnoreCase("Unica")) {
            flagObrigatoriedade = true;
            index = 3;
        }

        if (resposta.equalsIgnoreCase("Ate Data Limite")) {
            flagObrigatoriedade = true;
            index = 4;
        }

        if (resposta.equalsIgnoreCase("Justificada")) {
            flagObrigatoriedade = true;
            index = 1;
        }
    }

    public String getResultado() {
        return resultado;
    }
}
