package Activity9;

import java.util.ArrayList;

public class Activity9 
{
    public static void main(String[] args) 
    {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("Diana");
        myList.add("Sam");
        System.out.println("All names in the list:");
        for (int i = 0; i < myList.size(); i++) 
        {
            System.out.println(myList.get(i));
        }
        String thirdName = myList.get(2);
        System.out.println("\nThe 3rd name in the list is: " + thirdName);
        String searchName = "Charlie";
        System.out.println("\nDoes the list contain '" + searchName + "'? " + myList.contains(searchName));
        System.out.println("\nNumber of names in the list: " + myList.size());
        myList.remove("Bob");
        System.out.println("\nAfter removing 'Bob', new size: " + myList.size());
    }
}
