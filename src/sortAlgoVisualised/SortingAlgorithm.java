package sortAlgoVisualised;


import java.util.Random;

public class SortingAlgorithm {
		
	public int[] sortArray;
	
	 int arr[] = {12, 11, 13, 5, 6, 7}; //small test array
	
	public void initialiseArray(int size)
	{
	
		Random rand = new Random();
		sortArray = new int[size];
	
		//for each? To Do
		for(int i = 0; i < sortArray.length; i++)
		{
			sortArray[i] = rand.nextInt(100) + 1;
			System.out.println(sortArray[i]);
		}
	}
	
	
	
	public void bubbleSort(int currentPosition) //rough method To Do
	{	
		if(sortArray[currentPosition] > sortArray[currentPosition + 1])
		{
			int temp = sortArray[currentPosition];
			sortArray[currentPosition] = sortArray[currentPosition + 1];
			sortArray[currentPosition + 1] = temp; 
		}
	}

	
	public void intsort2(int j) //sort method To Do
	{
		int temp = sortArray[j-1];
		sortArray[j-1] = sortArray[j];
		sortArray[j] = temp;
		
		
	}

	
	public void outputArray(int[] arr)
	{
		for(int i =0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " , ");
		}
	}


}
