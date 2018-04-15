/*LaToya Anderson
 * CISC 1155
 * April 11, 2018
 */
/*This program reads in a file with a set of integers into an
 * array, counts how many are read in,
 * counts to the total number of zeros in the array,
 * and prints these to a file. Then it reads in more integers,
 * appending the array, recounts the entire array and as well as the
 * zeros, and prints the same file.
 */
import java.io.*;
import java.util.Scanner;

public class CountZeroNum {
	
	/* Input: vals - used to read in array of integers from from
	 * Process: Read in integers into vals array
	 * 			Increment total set
	 * Output: Print vals array to Printnum output file
	 * 		   Return total data set value to main
	 */
	public static int readData(int[] vals, 
			PrintWriter oldNumFile) throws IOException{
		/*Holds total number of filled array elements 
		read in from NewNumbers file*/
		int n = 0;
		
		//Instantiates File to read in NewNumbers file 
		File oldFile = new File("/home/latoya/eclipse-"
				+ "workspace/CountZeros/NewNumbers.txt");
		
		//Instantiates Scanner object to print NewNumbers file
		Scanner inputFile = new Scanner(oldFile);
		
		//Reads in NewNumbers file into vals array
		while(inputFile.hasNext()) {
			
			//Inserts integers into vals array
			vals[n]= inputFile.nextInt();
			
			//Counts number of elements filled with new data
			n++;
		}
		//Title of val arrays list before appending
		oldNumFile.println("Original Data Set of Integers");
		
	    System.out.println("Original Data Set of Integers");	
		
	    //Prints val array to screen
		for(int i = 0; i < n; i++)
			System.out.println(vals[i]);
		
		//Prints array to printNum file
		for(int i = 0; i < n; i++)
			oldNumFile.println(vals[i]);
		
		System.out.println("There are " + n +" numbers in "
				+ "this array");
		oldNumFile.println("There are " + n +" numbers in "
				+ "this array");
		
		//oldNumFile.println();
		
		//Flushes buffer to print vals array to printNum array
		oldNumFile.flush();
		
		//Closes printNum file
		//oldNumFile.close();
		
		/*Returns total data read into vals array 
		from NewNumbers file to main*/
		return n;
	}
	
	/*Input: vals - Holds read in values from NewNumbers 
	 * 				file in array
	 * 			n - Holds total number of values in vals array
	 * Process: Counts total number of zeros in vals array
	 * Output:  Prints total number of zeros before appending 
	 * 			to Printnum file
	 * 			Returns countZeros - total number of zeros in
	 * 			 vals array
	 */
	public static int countZeros(int[] vals, int n, 
			PrintWriter outPut) {
			
		//Holds total number of zeros in vals array
		int countZeros = 0;
		
		//Iterates through val array
		for(int index = 0; index < n; index++) {
			
			//Checks if there are zeros within vals array
			if(vals[index] == 0 )	
				//Holds total number of zeros in vals array
				countZeros++;
		}
		
		//Returns total number of zeros to screen
		return countZeros;
	}
	
	
	/*Input: vals - array of integers to be appended
	 * 			n - total number of read in integers 
	 * 				to be updated
	 * Process: Add integers from AddNewNums file to 
	 * 				vals array
	 * Output: Returns newTotal, the updated val array size
	 * 
	 */
	public static int append(int[] vals, int n, PrintWriter outPut) throws IOException {
	
		/*Increments and is added to n to add more integers 
			to vals array*/
		int index = 0;
		int newTotal;
		File fileNewNum = new File("/home/latoya/eclipse-workspace"
				+ "/CountZeros/AddNewNumbers.txt");
		
		//Instantiates Scanner object to read in AddNewNumber file
		Scanner inputNewNumbers = new Scanner(fileNewNum);
		
		//Appends AddNewNumber file to vals array
		while(inputNewNumbers.hasNext()) {
			
			vals[index+n] = inputNewNumbers.nextInt();
			index++;
		}
		
		System.out.println("\nUpdated Data Set of Numbers");
		
		outPut.println("\nUpdated Data Set of Numbers");
		
		//Prints updated vals array list to PrintNum file
		for(newTotal = 0; newTotal < index+n; newTotal++) {
			System.out.println(vals[newTotal]);
			outPut.println(vals[newTotal]);
			}
		
		System.out.println("New total number of integers is: "
		+ newTotal);
		
		outPut.println("New total of integers is: " + newTotal);
		
		outPut.flush();
		//outPut.close();
	
	//Returns updated val array size	
	return newTotal;	
	}
	
	/*Main creates the numbers array, creates a new file printNum
	to print arrays and totals, and calls all methods to 
	perform each task*/
	public static void main(String[] args) throws IOException{
		/*size - holds read in numbers array size
		 * zero - holds total number of zeros
		 * newSize - holds new numbers array size
		 * newZeros - holds new total number of zeros*/
		int size, zero, newSize,newZeros;
		
		//Maximum number of elements in numbers array
		final int MAX = 100;
		
		//Creates array to read in integers
		int[] numbers = new int[MAX];
		
		/*Instantiates PrintWriter object to print to 
		printNum file*/
		PrintWriter oldNumFile = new PrintWriter("/home/latoya/"
				+ "eclipse-workspace/CountZeros/printNum.txt");
		
		/*Calls method to read in NewNumbers and 
		returns numbers array size to size variable*/
		size = readData(numbers,oldNumFile);
		
		/*Calls method to count number of zeros
		 * in numbers array and returns
		 number to zero variable*/
		zero = countZeros(numbers,size,oldNumFile);
		
		//Prints total number of zeros to screen
		System.out.println("There are " + zero + " zeros");
		//Prints total number to printNum file
		oldNumFile.println("There are " + zero + " zeros");
		
		/*Calls method to append numbers from AddNewNumbers
		 * file and returns new numbers array size*/
		newSize = append(numbers,size,oldNumFile);
		
		/*Calls method to recount total number of zeros
		 * and returns new total number of zeros*/
		newZeros = countZeros(numbers,newSize,oldNumFile);
		
		//Prints total number of zeros to screens
		System.out.println("There are " + newZeros + " zeros");
		//Prints total number of zeros to file
		oldNumFile.println("There are " + newZeros + " zeros");
		
		oldNumFile.flush();
		oldNumFile.close();
	}

}
