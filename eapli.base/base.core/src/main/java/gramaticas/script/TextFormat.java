package gramaticas.script;

public class TextFormat {
    public static String formatarTexto(String email){
        StringBuilder stringBuilder = new StringBuilder();
        for (char palavra:email.toCharArray()) {
            if(palavra=='#'){
                stringBuilder.append("\n");
            }else{
                stringBuilder.append(palavra);
            }
        }
        return stringBuilder.toString();
    }
}
