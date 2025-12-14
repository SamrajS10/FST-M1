package Activity12;

interface Addable 
{
    int add(int num1, int num2);
}

public class Activity12 
{
    public static void main(String[] args) 
    {
        Addable ad1 = (a, b) -> (a + b);
        Addable ad2 = (int a, int b) -> 
        {
            return (a + b);
        };
        System.out.println("Result from ad1: " + ad1.add(5, 10));
        System.out.println("Result from ad2: " + ad2.add(20, 30));
    }
}

