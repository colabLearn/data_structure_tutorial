package src.linked_list;

/**
 * Example class to demonstrate creating your own exception handling class.
 */
public class invalidListPosition extends Exception
{

    public invalidListPosition()
    {
       System.out.println("Cannot add to list: invalid position to add to.");
     
    }


}
