package src.Stack;

/**
 * Example class to demonstrate creating your own exception handling class.
 */
public class StackOverflowException extends Exception
{

    public StackOverflowException()
    {
        
       System.out.println("Push attempt on full stack");
    }


}
