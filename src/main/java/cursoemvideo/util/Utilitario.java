package cursoemvideo.util;

public class Utilitario {

    public static String imprimeSeparador(final String string) {

        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append("=");
        }

        return stringBuilder.toString();
    }
}
