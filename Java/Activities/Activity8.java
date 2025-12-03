package Activity8;

class CustomException extends Exception 
{
    private String message = null;

    public CustomException(String message) 
    {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 
{
    public static void exceptionTest(String value) throws CustomException 
    {
        if (value == null) 
        {
            throw new CustomException("Error: The string value cannot be null!");
        } else 
        {
            System.out.println(value);
        }
    }
    public static void main(String[] args) 
    {
        try 
        {
            Activity8.exceptionTest("Will print to console");
        } 
        catch (CustomException e) 
        {
            System.out.println(e.getMessage());
        }

        try 
        {
            Activity8.exceptionTest(null);
        } 
        catch (CustomException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
