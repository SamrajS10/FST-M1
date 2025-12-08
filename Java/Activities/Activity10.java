package Activity10;

import java.util.HashSet;

public class Activity10 
{
    public static void main(String[] args) 
    {
        HashSet<String> hs = new HashSet<>();
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Mango");
        hs.add("Orange");
        hs.add("Grapes");
        hs.add("Pineapple");
        
        System.out.println("Size of HashSet: " + hs.size());
        hs.remove("Mango");
        
        System.out.println("After removing 'Mango': " + hs);
        boolean removed = hs.remove("Strawberry");
        System.out.println("Trying to remove 'Strawberry': " + removed);

        System.out.println("Does HashSet contain 'Apple'? " + hs.contains("Apple"));
        System.out.println("Does HashSet contain 'Mango'? " + hs.contains("Mango"));
        System.out.println("Updated HashSet: " + hs);
    }
}

