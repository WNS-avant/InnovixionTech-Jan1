import java.util.*;
public class CalcInterface 
{
	public static void main(String[]args)
	{
		Scanner scanner = new Scanner(System.in);

        System.out.println("               ==> Command Interface Calculator <==");
        System.out.println("      _________________________-----___________________________");
        System.out.println("");
        System.out.println("Addition - Subtraction - Multiplication - Division - Power - Comparing");
        System.out.println("");
        System.out.println("Enter your expression or 'exit' to quit.");

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
		String [] bit =	input.split("(?<=[+\\-*/^><])|(?=[+\\-*/^><])");
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
