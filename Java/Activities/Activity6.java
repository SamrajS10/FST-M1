package Activity6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane 
{
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOff;
    private Date lastTimeLanded;

    public Plane(int maxPassengers) 
    {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void onboard(String passenger) 
    {
        if (passengers.size() < maxPassengers) 
        {
            passengers.add(passenger);
        } else 
        {
            System.out.println("Plane is full. Cannot add more passengers.");
        }
    }

    public Date takeOff() {
        lastTimeTookOff = new Date();
        return lastTimeTookOff;
    }

    public void land() {
        lastTimeLanded = new Date();
        passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}

public class Activity6 
{
    public static void main(String[] args) 
    {
        Plane plane = new Plane(10);

        plane.onboard("Alice");
        plane.onboard("Bob");
        plane.onboard("Charlie");

        System.out.println("Take-off time: " + plane.takeOff());

        System.out.println("Passengers onboard: " + plane.getPassengers());

        try 
        {
            Thread.sleep(5000);
        } catch (InterruptedException e) 
        {
            System.out.println("Sleep was interrupted.");
        }


        plane.land();

        System.out.println("Landing time: " + plane.getLastTimeLanded());
    }
}

