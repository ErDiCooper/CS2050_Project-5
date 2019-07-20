public class Postfix 
{

   /**
     * convertToPostfix - converts an infix formatted expression to postfix.
     *
     * @param infix - a infix-formatted expression to be converted.
     * @return result - the converted postfix expression (or error).
   */
   public static String convertToPostfix(String infix) 
	{
		LinkedStack<String> stack = new LinkedStack<>(); // A stack for the arrangement of postfix characters.
		String shortInfix = infix.replaceAll(" ",""); // an version of the infix expression without whitespace.
		String[] splitString = shortInfix.split(""); // A String array to hold each character of the infix.
		String result = ""; // The postfix expression to be returned.
		int parenLeftCount = 0; // The number of left parenthesis.
		int parenRightCount = 0; // The number of right parethesis.
		boolean lastWasValue = false; // Whether or not the last character was a value.
		
		for (String character : splitString) 
		{
			if (isOperator(character)) 
			{
				lastWasValue = false;
				if ("(".equals(character)) 
				{
					parenLeftCount++;
				}
				if (")".equals(character)) 
				{
					parenRightCount++;
					if (parenRightCount > parenLeftCount) 
					{
						return "None. Invalid syntax. (Missing Parentheses.)";
					}
					while (!stack.isEmpty() && !"(".equals(stack.peek())) 
					{
						result += stack.pop();
						result += " ";
					}
					if (!stack.isEmpty()) 
					{
						stack.pop();
					}
				} 
				else 
				{
					if (!stack.isEmpty() && !getPrecedence(character, stack.peek())) 
					{
						stack.push(character);
					} 
					else 
					{
						while (!stack.isEmpty() && getPrecedence(character, stack.peek())) 
						{
							String top = stack.pop();

							if (!"(".equals(top)) 
							{
								result += top;
								result += " ";
							}
						}
						stack.push(character);
					}
				}
			} 
			else 
			{
				if (lastWasValue) 
				{
					return "None. Invalid syntax. (Missing Operator.)";
				}
				result += character;
				result += " ";
				lastWasValue = true;
			}
		}
      
		if (parenLeftCount != parenRightCount) 
		{
			return "None. Invalid syntax. (Missing Parentheses.)";
		}
		while (!stack.isEmpty()) 
		{
	   	result += stack.pop();
         result += " ";
		}

		return result;
	} // End of convertToPostfix
   
   //*****************************************************************************************

   /**
     * getPrecedence - Ensure the order of operations is correctly represented within the postfix.
     *
     * @param character - The operator currently being added postfix.
     * @param character1 - The most recent operator placeed into the Stack.
     * @return True/False, whether or not they conflict.
   */
	private static boolean getPrecedence(String character, String character1) 
	{
		switch (character) 
		{
		case "+":
			return "-".equals(character1) || "/".equals(character1) ||
                "*".equals(character1) || "^".equals(character1) ;
		case "-":
			return "+".equals(character1) || "/".equals(character1) ||
                "*".equals(character1) || "^".equals(character1) ;

		case "*":
			return "/".equals(character1) || "^".equals(character1) ;
		case "/":
			return "*".equals(character1) || "^".equals(character1) ;

		case "^":
			return "(".equals(character1);
			
		default:
			return false;
		}

	} // End of getPrecedence
	
   //*****************************************************************************************
   
   /**
     * isOperator - Determines if the passed in character is an operator.
     *
     * @param s - A character that may or may not be an operator.
     * @return Whether or not the character is an operator.
   */
	private static boolean isOperator(String s) {
		return "+".equals(s) || "-".equals(s) || "*".equals(s) ||
             "/".equals(s) || "^".equals(s) || "(".equals(s) ||
				 ")".equals(s);
	} // End of isOperator.

} // End of Postfix Class.