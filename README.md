**COMMAND-LINE CALCULATOR**
The input evaluation process in this program involves calling the evaluate method with the user's input to calculate the result. Within a try block, various exceptions are caught: ArithmeticException for handling division by zero or other arithmetic errors, NumberFormatException for detecting invalid operators, and a general Exception for any other expression errors. The method then prints either the result or an appropriate error message.

In the evaluate method, the input string is split into operands and operators using a regular expression. These operands are then parsed as double values, and the specified operation (addition, subtraction, etc.) is performed based on the operator using a switch statement. To prevent division by zero errors, the method checks if the divisor is not zero before performing division. For comparison operations, the compareOperands method is invoked.

The compareOperands method compares two operands using the specified comparison operator (less than or greater than) and returns a boolean result. This structured approach ensures accurate evaluation of arithmetic expressions and comparisons, enabling the program to handle a variety of user inputs effectively.




