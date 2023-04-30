package src.stack;

/**
 * Example class to demonstrate creating your own exception handling class.
 */
public class EmptyStackException extends Exception
{
 private EmptyStackExceptionEnum condition;

    public EmptyStackException(EmptyStackExceptionEnum condition)
    {
       this.condition = condition;
     
    }

    @Override
    public String getMessage(){
        if(condition==EmptyStackExceptionEnum.peek){
            return "Pop attempt on empty stack";
        }else{
            return "Peek attempt on empty stack";
        }
    }



}
