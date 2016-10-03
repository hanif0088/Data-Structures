public class SelectionSort 
{
	public static void main(String[] args) 
	{
		int[] myArray = {1,23,45,11,9,7,67,99};
		myArray = doSelectionSort(myArray);
		
		for(int i = 0; i<myArray.length; i++)
		{
			System.out.println(myArray[i]);
		}
	}
	
	//Time complexity best case Ω(n^2), average case Θ(n^2), worst case O(n^2) and space complexity O(1)
	public static int[] doSelectionSort(int[] array)
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			// Find the index of the minimum value
			int minPosition = i;
			for(int j= i+1; j < array.length; j++)
			{
				if( array[j] < array[minPosition])
				{
					minPosition = j;
				}
				//swapping the two values 
				int smallerNumber = array[minPosition];
				array[minPosition] = array[i];
				array[i] = smallerNumber;
			}
		}
		return array;
	}
}
