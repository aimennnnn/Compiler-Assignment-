public class ExpressionEvaluator {
    public static double evaluate(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                pos++;
                while (pos < expression.length() && expression.charAt(pos) == ' ') {
                    pos++;
                }
                ch = (pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length())
                    throw new RuntimeException("Unexpected: " + (char) ch);
                return Math.round(x * 100000.0) / 100000.0;
            }

            double parseExpression() {
                double x = parseTerm();
                while (ch == '+' || ch == '-') {
                    if (ch == '+') {
                        nextChar();
                        x += parseTerm();
                    } else {
                        nextChar();
                        x -= parseTerm();
                    }
                }
                return x;
            }

            double parseTerm() {
                double x = parseFactor();
                while (ch == '*' || ch == '/' || ch == '%') {
                    if (ch == '*') {
                        nextChar();
                        x *= parseFactor();
                    } else if (ch == '/') {
                        nextChar();
                        x /= parseFactor();
                    } else if (ch == '%') {
                        nextChar();
                        x %= parseFactor();
                    }
                }
                return x;
            }

            double parseFactor() {
                if (ch == '+') { nextChar(); return parseFactor(); }
                if (ch == '-') { nextChar(); return -parseFactor(); }

                double x;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else if (ch == '(') {
                    nextChar();
                    x = parseExpression();
                    if (ch == ')') nextChar();
                    else throw new RuntimeException("Expected closing parenthesis");
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (ch == '^') {
                    nextChar();
                    x = Math.pow(x, parseFactor());
                }

                return x;
            }
        }.parse();
    }
}
