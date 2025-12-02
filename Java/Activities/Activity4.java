package Activity4;

public class Activity4 
{
	public static void main(String args[])
	{
	int[] numbers = {1,30,15,60,10,55,40,25,20};
	System.out.println("Before the Sorting:");
	displayArray(numbers);
	
	insertionsort(numbers);
	
	System.out.println("After the Sorting:");
	displayArray(numbers);
	}
	private static void insertionsort(int[] arr) 
	{
		for (int i = 1; i < arr.length; i++) 
		{
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
	}
	private static void displayArray(int[] arr) 
	{
		for (int num : arr) 
		{
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
