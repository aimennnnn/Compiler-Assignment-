import java.util.List;

public class ErrorHandler {
    public static void validateTokens(List<String> tokens) {
        for (String token : tokens) {
            if (token.matches("[A-Z]")) {
                throw new RuntimeException("Invalid token: " + token + ". Identifiers must be lowercase.");
            }
        }
    }
}
