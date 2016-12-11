package info.duhovniy.mathclasses.commons;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static java.lang.Double.valueOf;

@Component
public class MathUtils {

    private Map<Character, Operator> map = new HashMap<>();
    private String ops;

    public MathUtils() {
        StringBuilder sb = new StringBuilder();

        for (Operator o : Operator.values()) {
            System.out.println(o.getSymbol() + " -> " + o.ordinal());
            sb.append(o.getSymbol());
            map.put(o.getSymbol(), o);
        }

        ops = sb.toString();
    }

    public String infixToPostfix(String infix) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        for (String token : infix.split("\\s")) {
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            // check for operator
            if (idx != -1) {
                if (s.isEmpty())
                    s.push(idx);

                else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2); // -2 stands for '('
            } else if (c == ')') {
                // until '(' on stack, pop operators.
                while (s.peek() != -2)
                    sb.append(ops.charAt(s.pop())).append(' ');
                s.pop();
            } else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty())
            sb.append(ops.charAt(s.pop())).append(' ');
        return sb.toString();
    }

    public double expressionCounter(String inputExpression) {
        Stack<String> stack = new Stack<>();
        for (String token : inputExpression.split("\\s")) {
            if (map.containsKey(token.charAt(0))) {
                double y = valueOf(stack.pop());
                double x = valueOf(stack.pop());
                stack.push(String.valueOf(map.get(token.charAt(0)).getLambda().binary(x, y)));
            } else {
                stack.push(token);
            }
        }
        return valueOf(stack.pop());
    }

    public String prepareString(String input) {

        if (input.isEmpty())
            return "Error: String is empty";

        input = input.trim();

        if (map.containsKey(input.charAt(0)) || map.containsKey(input.charAt(input.length() - 1)))
            return "Error: String cannot start or end with operator";

        StringBuilder sb = new StringBuilder();
        int parenthesesCounter = 0;
        boolean wasDot = false;
        boolean wasOperator = false;
        boolean isDigit = false;

        for (Character c : input.toCharArray()) {

            if (Character.isDigit(c)) {
                isDigit = true;
                wasOperator = false;
                sb.append(c);
            }

            if (c == '.') {
                if (wasDot) {
                    return "Error: Too many dots in single digit";
                }
                isDigit = true;
                wasDot = true;
                if (wasOperator) {
                    wasOperator = false;
                    sb.append(' ');
                }
                sb.append(c);
            }

            if (c == '(') {
                parenthesesCounter++;
                if (wasOperator) {
                    wasOperator = false;
                }
                if (isDigit)
                    return "Error: No operator between digit and (";
                sb.append(c);
                sb.append(' ');
            }

            if (c == ')') {
                if (parenthesesCounter > 0) {
                    parenthesesCounter--;
                    if (wasOperator) {
                        return "Error: Operator was not closed";
                    }
                    if (isDigit) {
                        sb.append(' ');
                        isDigit = false;
                    }
                    sb.append(c);
                    sb.append(' ');
                } else {
                    return "Error: Parentheses error";
                }
            }

            if (map.containsKey(c)) {
                if (wasOperator) {
                    return "Error: Two operators together";
                }
                if (isDigit) {
                    sb.append(' ');
                    isDigit = false;
                    wasDot = false;
                }
                wasOperator = true;
                sb.append(c);
                sb.append(' ');
            }
        }

        if (parenthesesCounter != 0)
            return "Error: Parentheses error";
        return sb.toString();
    }

}
