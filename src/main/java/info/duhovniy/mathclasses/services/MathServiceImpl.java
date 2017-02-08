package info.duhovniy.mathclasses.services;

import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.commons.Operator;
import info.duhovniy.mathclasses.dto.Expression;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Pattern;

import static info.duhovniy.mathclasses.commons.MathUtils.evaluateExpressionToList;
import static info.duhovniy.mathclasses.commons.MathUtils.round;
import static java.lang.Double.valueOf;


@Component
public class MathServiceImpl implements MathService {

    private final Map<Character, Operator> operatorHashMap = new HashMap<>();
    // TODO: delete - use operatorHashMap instead
    private final String ops;

    public MathServiceImpl() {
        StringBuilder sb = new StringBuilder();

        for (Operator o : Operator.values()) {
            // TODO: remove in production
            System.out.println(o.toString() + " " + o.getSymbol() + " -> " + o.ordinal());
            sb.append(o.getSymbol());

            operatorHashMap.put(o.getSymbol(), o);
        }

        ops = sb.toString();
    }

    @Override
    public double calculateExpression(Expression input) throws MathException {
        Deque<String> stack = new LinkedList<>();
        for (String token : infixToPostfixList(input.getBody())) {
            if (operatorHashMap.containsKey(token.charAt(0))) {
                double y = valueOf(stack.pop());
                double x = valueOf(stack.pop());
                if (operatorHashMap.get(token.charAt(0)).compareTo(Operator.DIVIDE) == 0 && y == 0)
                    throw new MathException("Error: Divide by ZERO");
                stack.push(String.valueOf(operatorHashMap.get(token.charAt(0)).getLambda().binary(x, y)));
            } else {
                stack.push(token);
            }
        }
        return valueOf(stack.pop());
    }

    @Override
    public List<String> prepareString(String input) throws MathException {

        if (input.isEmpty())
            throw new MathException("Error: Expression string is empty");

        input = input.trim();

        Pattern.compile(" ").splitAsStream(input).forEach(System.out::println);

        if (operatorHashMap.containsKey(input.charAt(0)) || operatorHashMap.containsKey(input.charAt(input.length() - 1)))
            throw new MathException("Error: Expression string cannot start or end with operator");

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
                    throw new MathException("Error: Too many dots in single digit");
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
                    throw new MathException("Error: No operator between digit and parentheses");
                sb.append(c);
                sb.append(' ');
            }

            if (c == ')') {
                if (parenthesesCounter > 0) {
                    parenthesesCounter--;
                    if (wasOperator) {
                        throw new MathException("Error: Operator was not closed");
                    }
                    if (isDigit) {
                        sb.append(' ');
                        isDigit = false;
                    }
                    sb.append(c);
                    sb.append(' ');
                } else {
                    throw new MathException("Error: Parentheses error");
                }
            }

            if (operatorHashMap.containsKey(c)) {
                if (wasOperator) {
                    throw new MathException("Error: Two operators together");
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
            throw new MathException("Error: Parentheses error");

        return Arrays.asList(sb.toString().split(" "));
    }

    @Override
    public Expression evaluateExpressionToExpression(Expression expression) throws MathException {

        expression.setBody(evaluateExpressionToList(expression));
        expression.setTempResult(round(calculateExpression(expression), expression.getRank()));
        return expression;
    }

    private List<String> infixToPostfixList(List<String> infix) {

        Deque<Integer> stack = new LinkedList<>();
        List<String> postfix = new ArrayList<>();

        for (String token : infix) {

            if (token.isEmpty())
                continue;

            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            // check for operator
            if (idx != -1) {
                if (stack.isEmpty())
                    stack.push(idx);

                else {
                    while (!stack.isEmpty()) {
                        int prec2 = stack.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            postfix.add(String.valueOf(ops.charAt(stack.pop())));
                        else break;
                    }
                    stack.push(idx);
                }
            } else if (c == '(') {
                stack.push(-2); // -2 stands for '('
            } else if (c == ')') {
                // until '(' on stack, pop operators.
                while (stack.peek() != -2)
                    postfix.add(String.valueOf(ops.charAt(stack.pop())));
                stack.pop();
            } else {
                postfix.add(token);
            }
        }
        while (!stack.isEmpty())
            postfix.add(String.valueOf(ops.charAt(stack.pop())));
        return postfix;
    }

}
