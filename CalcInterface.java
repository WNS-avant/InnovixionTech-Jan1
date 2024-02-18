import java.util.*;
public class CalcInterface 
{
	public static void main(String[]args)
	{
		Scanner scanner = new Scanner(System.in);

        System.out.println("               ==> Command Interface Calculator <==");
        System.out.println("      _________________________-----___________________________");
        System.out.println("");
        System.out.println("Choose from Addition, Subtraction, Multiplication, Division, Power(^), Factorial(!) or Comparison(<,>)");
        System.out.println("");
        System.out.println("Enter your expression in this format: for example, '2+3', or type 'exit' to quit.");
        while (true) 
        {
            System.out.print("-> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) 
            {
                System.out.println("Goodbye!");
                break;
            }
            try 
            {
                double result = evaluate(input);
                if(result==0)
                {
                System.out.println("FALSE");
                }
                else if(result==1)
                {
                    System.out.println("TRUE");
                }
                else
                System.out.println("Result: " + result);
            } 
            catch (ArithmeticException e) 
            {
                System.out.println(e);
            }
            catch (NumberFormatException e) 
            {
               System.out.println("Invalid operator");
            }
            catch (Exception e) 
            {
                System.out.println("Invalid expression. Please try again.");
            }
        }

        scanner.close();
    }

	private static double evaluate(String input) 
	{    
        if (input.contains("!")) 
        {
            String[] bit = input.split("!");
            if (bit.length != 1) 
            {
                throw new IllegalArgumentException("Invalid factorial expression");
            }
            double operand = Double.parseDouble(bit[0]);
            return factorial(operand);
        } 
        else 
        {
            String[] bit = input.split("(?<=[+\\-*/^><])|(?=[+\\-*/^><])");
            if (bit.length != 3) 
            {
                throw new IllegalArgumentException("Invalid expression format");
            }
		    double operand1 =  Double.parseDouble(bit[0]);
		    String operator = bit[1];
		    double operand2 =  Double.parseDouble(bit[2]);
	
		    switch(operator)
		    {
			    case "+" : return (operand1 + operand2);
			    case "-" : return (operand1 - operand2);
			    case "^" : return (Math.pow(operand1, operand2));
			    case "*" : return (operand1 * operand2);
			    case "/" : if(operand2!=0)
						    {
							    return (operand1 / operand2);
						    }
						    throw new ArithmeticException("Division by zero. Not a valid expression");
			    case "<": return compareOperands(operand1, operand2, operator) ? 1 : 0;
			    case ">": return compareOperands(operand1, operand2, operator) ? 1 : 0;

                default: throw new NumberFormatException();
	        }
        }
	}

	private static double factorial(double operand) {
        if (operand <= 1) {
            return 1; 
        }
        double fact = 1;
        for (double i = 1; i <= operand; i++) {
            fact *= i;
        }
        return fact;
    }

    private static boolean compareOperands(double operand1, double operand2, String operator) 
	{
	    switch (operator) 
	    {
	        case "<": return operand1 < operand2;
	        case ">": return operand1 > operand2;
	        
	        default: throw new IllegalArgumentException("Invalid operator for comparision");
	    }
	}
	
}
