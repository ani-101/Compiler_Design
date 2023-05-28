import java.util.Scanner;

public class Parser {
    private String input;
    private int index;
    
    public Parser(String input) {
        this.input = input;
        this.index = 0;
    }
    
    public double parse() {
        return expression();
    }
    
    private double expression() {
        double result = term();
        
        while (index < input.length()) {
            char operator = input.charAt(index);
            if (operator != '+' && operator != '-') {
                break;
            }
            index++;
            
            double term = term();
            if (operator == '+') {
                result += term;
            } else {
                result -= term;
            }
        }
        
        return result;
    }
    
    private double term() {
        double result = factor();
        
        while (index < input.length()) {
            char operator = input.charAt(index);
            if (operator != '*' && operator != '/') {
                break;
            }
            index++;
            
            double factor = factor();
            if (operator == '*') {
                result *= factor;
            } else {
                result /= factor;
            }
        }
        
        return result;
    }
    
    private double factor() {
        double result;
        char ch = input.charAt(index);
        if (ch >= '0' && ch <= '9') {
            result = number();
        } else if (ch == '(') {
            index++;
            result = expression();
            index++;
        } else {
            throw new RuntimeException("Invalid input: " + ch);
        }
        return result;
    }
    
    private double number() {
        double result = 0;
        while (index < input.length()) {
            char ch = input.charAt(index);
            if (ch < '0' || ch > '9') {
                break;
            }
            result = result * 10 + (ch - '0');
            index++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String input = scanner.nextLine();
        scanner.close();
        
        Parser parser = new Parser(input);
        double result = parser.parse();
        System.out.println("Result: " + result);
    }
}
