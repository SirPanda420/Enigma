import java.util.Scanner;
import java.io.*;
import java.util.*; 
public class Main {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to my enigma machine...");
		System.out.println("Enter position for rotor 1, enter number 1-26");
		String in1 = scan.nextLine();
		
		//validation
		int pos1=0; boolean valid = false;
		while(!valid)
		{
			if(in1.matches("\\d+"))
			{
				pos1 = Integer.parseInt(in1);
				if(pos1<27 && pos1>0)
					valid = true;
				else
				{
					System.out.println("Not an integer within the bounds, try again...");
					in1 = scan.nextLine();
				}
			}
			else
			{	
				System.out.println("Not an integer, try again");
				in1 = scan.nextLine();
			}
		}
		
		
		System.out.println("Enter position for rotor 2, enter number 1-26");
		String in2 = scan.nextLine();
		int pos2=0; boolean valid2 = false;
		while(!valid2)
		{
			if(in2.matches("\\d+"))
			{
				pos2 = Integer.parseInt(in2);
				if(pos2<27 && pos2>0)
					valid2 = true;
				else
				{
					System.out.println("Not an integer within the bounds, try again...");
					in2 = scan.nextLine();
				}
			}
			else
			{	
				System.out.println("Not an integer, try again");
				in2 = scan.nextLine();
			}
		}
		
		System.out.println("Enter position for rotor 3, enter number 1-26");
		String in3 = scan.nextLine();
		int pos3=0; boolean valid3 = false;
		while(!valid3)
		{
			if(in3.matches("\\d+"))
			{
				pos3 = Integer.parseInt(in3);
				if(pos3<27 && pos3>0)
					valid3 = true;
				else
				{
					System.out.println("Not an integer within the bounds, try again...");
					in3 = scan.nextLine();
				}
			}
			else
			{	
				System.out.println("Not an integer, try again");
				in3 = scan.nextLine();
			}
		}
		
		//Initializing 
		Enigma machine = new Enigma(pos1,pos2,pos3);
		
		System.out.print("Enter the Statement you would like encoded: ");
		String input = scan.nextLine();
		String output = machine.Scramble(input);
		System.out.println("\nEncoding message...");
		System.out.print("Encoded Message is: " + output);
		
		
	}

}
