import java.util.List;

public class Compiler {
    public static void main(String[] args) {
        DFA dfa = new DFA();
        State s1 = new State(1, true);
        State s2 = new State(2, false);
        State s3 = new State(3, false);
        State s4 = new State(4, false);

        dfa.addState(s1);
        dfa.addState(s2);
        dfa.addState(s3);
        dfa.addState(s4);
        dfa.setStartState(s1);

        s1.addTransition('[', s2);
        s1.addTransition('\\', s3);
        s1.addTransition('/', s4);

        System.out.println("\nTransition State Table:");
        dfa.printStateTable();

        System.out.println("\nExpression evaluation for:");
        String expr = "3 + 5 * 2 ^ 2 - 4 / 2";
        System.out.println(expr);
        System.out.println("Result: " + ExpressionEvaluator.evaluate(expr));

        System.out.println("\nLexical Analysis:");
        String preprocessed = LexicalAnalyzer.preprocess("/* This is a comment */ 3 + 4 * 2 - 1");
        List<String> tokens = LexicalAnalyzer.tokenize(preprocessed);
        System.out.println("Tokens: " + tokens);

        try {
            ErrorHandler.validateTokens(tokens);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        SymbolTable.add("x", "Integer");
        SymbolTable.addConstant("pi", "Decimal", "3.14159");
        SymbolTable.printTable();

        System.out.println("\n");
    }
}