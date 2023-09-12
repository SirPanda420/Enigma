import java.util.*; 
import java.util.ArrayList;

public class Rotor 
{
	private ArrayList<Integer> wheel;
	private int position;
	private String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
	
	public Rotor(Integer[] a, int pos)
	{
		try 
		{
			wheel = new ArrayList<Integer>(Arrays.asList(a));
			position = 1;
			this.setRotation(pos);
		}
		catch(Exception e)
		{
			//System.out.println("Error" + e);
		}
	}
	
	//pulls int value at location p
	public int getRotorAt(int p)
	{
		return wheel.get(p);
	}
	
	//sets the rotor value at index loc to value val
	public void setRotorAt(int loc, int val)
	{
		wheel.set(loc,val);
	}
	
	//sets the rotation of the rotor to the desired position
	public void setRotation(int pos)
	{
		int temp = 0;
		for(int i=0;i<pos-1;i++)
		{
			for(int j=0;j<26;j++)
			{
				if(wheel.get(j)-1 < 0)
				{
					wheel.set(j,25);
				}
				else
				{
					wheel.set(j, wheel.get(j)-1);
				}
			}//end of j loop
			temp = wheel.get(0);
			wheel.remove(0);
			wheel.add(temp);
		}//end of i loop
		position = pos;
	}
	
	//rotates the wheel by 1
	public int Rotate()
	{
		++position;
		//determines if one full rotation has occurred
		boolean fullRotation = false;
		if(position>26)
		{
			position = 1;
			fullRotation = true;
		}
		
		//rotates the wheel values
		for(int i=0;i<26;i++)
		{
			if(wheel.get(i)-1 < 0)
			{
				wheel.set(i,25);
			}
			else
			{
				wheel.set(i, wheel.get(i)-1);
			}
		}
		int temp = wheel.get(0);
		wheel.add(temp);
		wheel.remove(0);
		
		if(fullRotation)
			return 1;
		return 0;
		
	}
	
	public int findLocation(int n)
	{
		int loc = 0;
		for(int i=0; i<wheel.size(); i++)
		{
			if(wheel.get(i) ==n)
			{
				loc = i;
			}
		}
		return loc;
	}

}//end of rotor
