import java.util.Arrays;

public class BinarySearch 
{
	public static void main(String[] args) 
	{
		int[] myArray = {11,45,9,67,100,31,5,112};
		Arrays.sort(myArray);
		System.out.println( binarySearch(myArray,112) );
	}
	
	//Time complexity O(logn)
	public static boolean binarySearch(int[] array,int key)
	{
		int first = 0;
		int last = array.length - 1;
		
		while(first <= last)
		{
			int mid = (first + last)/2;
			
			if( key == array[mid])
			{
				return true;
			}
			else if( key < array[mid] )
			{
				last = mid - 1;
			}
			else //if( key > array[mid] )
			{
				first = mid + 1;
			}
		}
		
		return false;
	}
}
