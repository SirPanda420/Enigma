import java.util.Arrays;

/**
 * 
 */

/**
 * @author David
 * Welcome to my enigma machine
 * 
 * This works by taking in a string value and breaking it up by its individual letters
 * and sending them along pathways between the rotors to change the letters
 * 
 */

public class Enigma 
{
	private Rotor rotor1;
	private Rotor rotor2;
	private Rotor rotor3;
    private String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
	private int[] reflector = { 5, 2, 1, 20, 12, 0, 10, 15, 16, 18, 6, 13, 4, 11, 21, 7, 8, 25, 9, 24, 3, 14, 23, 22, 19, 17};
	
	public Enigma(int pos1, int pos2, int pos3)
	{
		//instantiates rotors with the set pathways and rotates the rotor to the
		//desired position based off the user's inputs
        Integer[] temp = { 4, 10, 12, 5, 0, 3, 7, 6, 11, 25, 1, 8, 2, 16, 18, 24, 13, 19, 14, 17, 23, 22, 21, 20, 15, 9 };
        rotor1 = new Rotor(temp,pos1);
        
        Integer[] temp2 = { 1, 0, 14, 10, 9, 8, 23, 25, 5, 4, 3, 13, 18, 11, 2, 24, 17, 16, 12, 21, 22, 19, 20, 6, 15, 7 };
        rotor2 = new Rotor(temp2,pos2);
        
        Integer[] temp3 = { 10, 9, 19, 23, 21, 25, 22, 17, 13, 1, 0, 14, 15, 8, 11, 12, 20, 7, 24, 2, 16, 4, 6, 3, 18, 5 };
        rotor3 = new Rotor(temp3,pos3);
        
	}
	
	public String Scramble(String input)
	{
		//encrypted will be our ecrypted string after the method
		//let will be our temp value for each index of the input
		//loc will hold on to the pathway values to determine the end letter after the scramble
		String encrypted = "";
		String let = "";
		boolean uppercase = false;
		int loc = 0;
		
		for(int i=0;i<input.length();i++)
		{
			
			if(Character.isLetter(input.charAt(i)))
			{
				let = Character.toString(input.charAt(i));
				
				//checks to see if original value was uppercase
				uppercase = Character.isUpperCase(input.charAt(i));
				let = let.toLowerCase();
				//locates what index of the alphabet the letter is 
				loc = Arrays.binarySearch(alpha,let);
				
				//finds the next pathway based on the index of the alphabet
				loc = rotor1.getRotorAt(loc);
				
				//uses previous location to locate desired pathway
				loc = rotor2.getRotorAt(loc);
			
				loc = rotor3.getRotorAt(loc);
				
				
				//sends location on the rotor through the reflector
				loc = reflector[loc];
				
				//follows the pathways in reverse to spit out new letter
				loc = rotor3.findLocation(loc);
				
				loc = rotor2.getRotorAt(loc);
				loc = rotor1.getRotorAt(loc);
				
				let = alpha[loc];
				
				if(uppercase)
					let = let.toUpperCase();
				
				
				encrypted += let;
				
				Click();
				
			}
			else
				encrypted += input.charAt(i);
		}
		
		return encrypted;
	}//end of scramble
	
	
	//Rotates the rotor positions by 1, accounting for a full rotation
	public void Click()
	{
		int temp = rotor1.Rotate();
		if(temp==1)
		{
			int temp2 = rotor2.Rotate();
			if(temp2 == 1)
			{
				rotor3.Rotate();
			}
		}
	}
}
