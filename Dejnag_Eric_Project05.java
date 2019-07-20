/*
   CS2050 - Computer Science 2
   Dejnag Vang & Eric DiCarlo
   Project 5 - Postfix Converter
   Windows 10, Desktop, jGRASP
   Bazaar - n. - A market, typically found within Middle Eastern countries.
   “I'd rather die on an adventure than live standing still.”  - Victoria "V.E." Schwab (1987 - )
*/

import java.io.*;
import java.util.Scanner;

public class Dejnag_Eric_Project05 
{
	public static void main(String[] args) throws IOException 
   {   
      Postfix obj = new Postfix();
      final String INPUT_FILE = "Project_05_Input.txt"; // Name of the input file of infix expressions.
      final String OUTPUT_FILE = "Project_05_Output.txt"; // Name of the output file for postfix conversion.
      
      File inputFile = new File(INPUT_FILE); // The input file.
      
      Scanner input = new Scanner(inputFile); // Reads the input file.
      PrintWriter output = new PrintWriter(new FileWriter(OUTPUT_FILE)); // Writes to the output file.
      
      // Generate Output File.
      while (input.hasNext())
      {
         String infix = input.nextLine();
         output.print("The postfix expression for " + infix + " is: ");
         output.println(obj.convertToPostfix(infix));
      }
      output.close();
	} // End of main.   
} // End of Dejnag_Eric_Project05