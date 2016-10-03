public class BubbleSort 
{
	public static void main(String[] args) 
	{
		int[] myArray = {1,23,45,11,9,7,67,99};
		myArray = doBubbleSort(myArray);
		
		for(int i = 0; i<myArray.length; i++)
		{
			System.out.println(myArray[i]);
		}
	}
	
	//Time complexity best case Ω(n), average case Θ(n^2), worst case O(n^2) and space complexity O(1)
	public static int[] doBubbleSort(int[] array)
	{
		for(int i = 0; i< array.length; i++)
		{
			for(int j=1; j<array.length - i; j++)
			{
				if(array[j-1] > array[j])
				{
					//swapping the two values 
					int smallerNumber = array[j];
					array[j] = array[j-1];
					array[j-1] = smallerNumber;
				}
			}
		}
		return array;
	}
}

