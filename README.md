# countZeros
Topic 7: Arrays
import java.io.*;
import java.util.Scanner;
public class CountZeroNum {
	
	/*Input: vals - used to read in array of integers from from
	 * Process: Read in integers into vals array
	 * 			Increment total set
	 * Output: Print vals array to Printnum output file
	 * 		   Return total data set value to main
	 */
	public static int readData(int[] vals, PrintWriter oldNumFile) throws IOException{
		//Holds total number of filled array elements 
		//read in from NewNumbers file
		int n = 0;
		
		//Instantiates File to read in NewNumbers file 
		File oldFile = new File("/home/latoya/eclipse-workspace/CountZeros/NewNumbers.txt");
		
		//Instantiates Scanner object to print NewNumbers file
		Scanner inputFile = new Scanner(oldFile);
		
		//Reads in NewNumbers file into vals array
		while(inputFile.hasNext()) {
			vals[n]= inputFile.nextInt();
			n++;
		}
		
		//Prints val array to screen
		for(int i = 0; i < n; i++)
			System.out.println(vals[i]);
		
		//Title of val arrays list before appending
		oldNumFile.println("Original Data Set of Integers");
		
		//Prints array to printNum file
		for(int i = 0; i < n; i++)
			oldNumFile.println(vals[i]);
		
		//Flushes buffer to print vals array to printNum array
		oldNumFile.flush();
		
		//Closes printNum file
		oldNumFile.close();
		
		//Returns total data read into vals array from NewNumbers file to main
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
	public static int countZeros(int[] vals, int n, PrintWriter outPut) {
			
		//Holds total number of zeros in vals array
		int countZeros = 0;
		
		//Iterates through val array
		for(int index = 0; index < n; index++) {
			
			//Checks if there are zeros within vals array
			if(vals[index] == 0 )	
				//Holds total number of zeros in vals array
				countZeros++;
		}
		outPut.println("Number of zeros: " + countZeros);
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
		
		System.out.println("Updated Data Set of Numbers");
		
		outPut.println("Updated Data Set of Numbers");
		
		//Prints updated vals array list to PrintNum file
		for(newTotal = 0; newTotal < index+n; newTotal++) {
			System.out.println(vals[newTotal]);
			outPut.println(vals[newTotal]);
			}
		
		System.out.println("New total number of integers is: " + newTotal);
		outPut.println("New total of integers is: " + newTotal);
	
	//Returns updated val array size	
	return newTotal;	
	}
	
	public static void main(String[] args) throws IOException{
		int size, zero, newSize,newZeros;
		
		final int MAX = 100;
		
		int[] numbers = new int[MAX];
		
		//Instantiates PrintWriter object to print to printNum file
		PrintWriter oldNumFile = new PrintWriter("/home/latoya/"
				+ "eclipse-workspace/CountZeros/printNum.txt");
		
		size = readData(numbers,oldNumFile);
		
		zero = countZeros(numbers,size,oldNumFile);
		//Prints total nunber of zeros to screen
		System.out.println("There are " + zero + " zeros");
		oldNumFile.println("There are " + zero + " zeros");
		
		newSize = append(numbers,size,oldNumFile);
		
		newZeros = countZeros(numbers,newSize,oldNumFile);
		System.out.println("There are " + newZeros + " zeros");
		oldNumFile.println("There are " + newZeros + " zeros");
	}

}
