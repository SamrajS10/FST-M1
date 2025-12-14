package Activity11;

import java.util.HashMap;
import java.util.Map;

public class Activity11 
{
    public static void main(String[] args) 
    {

    	HashMap<Integer, String> colours = new HashMap<>();
        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Purple");
        System.out.println("Colours in the map: " + colours);
        colours.remove(2);
        System.out.println("After removing one colour: " + colours);
        boolean hasGreen = colours.containsValue("Green");
        System.out.println("Does the map contain Green? " + hasGreen);
        System.out.println("Size of the map: " + colours.size());
    }
}

