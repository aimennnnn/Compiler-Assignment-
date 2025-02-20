import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {
    public static String preprocess(String input) {
        input = input.replaceAll("/\\*.*?\\*/", "");  // Remove multi-line comments
        input = input.replaceAll("//.*", "");        // Remove single-line comments
        return input.replaceAll("\\s+", " ").trim(); // Normalize spaces
    }

    public static List<String> tokenize(String input) {
        String[] tokens = input.split("\\s+|(?<=[-+*/%^()=])|(?=[-+*/%^()=])");
        List<String> tokenList = new ArrayList<>();
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                tokenList.add(token.trim());
            }
        }
        return tokenList;
    }
}
