import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class DivisorsHash 
{
	// protect our input by setting it private
	private List<Integer> input;
	
	// create map to store our output
	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	
	//Aux List to facilitate the Divisors per each number
	List<Integer> divisorsList = new ArrayList<Integer>();
	
	//DivisorsHash constructor
	public DivisorsHash(List<Integer> input)
	{
		this.input = input;
	}

	// Get Input List
	public List<Integer> getInput() 
	{
		return input;
	}

	//Set the Input List
	public void setInput(List<Integer> input)
	{
		this.input = input;
	}
	
	// find the Divisors of a given number
	private List<Integer> findDividors(Integer inputKey)
	{
		 divisorsList.clear() ; // the List may contain elements from the previous call.
		 
		 boolean found = false; 
		 
		 // 1 divides every single number, so we exclude it 
		 // The loop starts from number 2 and ends on the previous number of the given one
		 for ( int num = 2; num < inputKey;  num++)
		 {
			 if ((inputKey % num) == 0)
			 {
				 divisorsList.add(num);
				 map.put(inputKey, divisorsList);
				 found = true;
			 }		  
		 }
		 // if the Number has no divisors, then clear its Divisors List
		 if ( found == false)
		 {
			 divisorsList.clear();
			 map.put(inputKey, divisorsList); 
		 }
		 
		 return divisorsList;
	}
	
	// read the Input list and produce the 
	public void init()
	{
		// sort the ArrayList
		Collections.sort(input) ;  		
		
		/*
		 * Loop through the Input, and if the element is not present in the HashMap
		 * then add it.
		 */
		for (Integer inputKey: input)
		{
			 if( ! map.containsKey(inputKey))
			 {
	             // Find the divisors of each element
				 // System.out.println("Finding the Divisors of: " + inputKey) ; 
				 this.findDividors(inputKey);
	    		System.out.println("key: " + inputKey + " value: " + map.get(inputKey));
		     }
		} // end for loop

}  // end of class 
	

	  public static void main(String[] argv) 
	  {
		  List<Integer> input = new ArrayList<Integer>();
		  // create dummy data to populate the List
		  input.add(10);
		  input.add(22);
		  input.add(1);
		  input.add(7);
		  input.add(992);
		  input.add(71);
		  input.add(78);
		  input.add(-4);
		  input.add(-22);
		  input.add(56);
		  input.add(1992);
		  input.add(211);
		  
		  // Create a new Divisorshash data structure and print the output
		  DivisorsHash dh = new DivisorsHash(input) ; 
		  dh.init() ; 
	  }
}  // end of class
