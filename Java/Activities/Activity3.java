package Activity3;

public class Activity3 
{
	public static void main(String args[]) 
	    {
	        double seconds = 1000000000;
	        double EarthSeconds = 31557600;
	        double MercurySeconds = 0.2408467;
	        double VenusSeconds = 0.61519726;
	        double MarsSeconds = 1.8808158;
	        double JupiterSeconds = 11.862615;
	        double SaturnSeconds = 29.447498;
	        double UranusSeconds = 84.016846;
	        double NeptuneSeconds = 164.79132;
	        System.out.println("Mercury age is: " + seconds / EarthSeconds / MercurySeconds);
	        System.out.println("Venus age is: " + seconds / EarthSeconds / VenusSeconds);
	        System.out.println("Earth age is: " + seconds / EarthSeconds);
	        System.out.println("Mars age is: " + seconds / EarthSeconds / MarsSeconds);
	        System.out.println("Jupiter age is: " + seconds / EarthSeconds / JupiterSeconds);
	        System.out.println("Saturn age is: " + seconds / EarthSeconds / SaturnSeconds);
	        System.out.println("Uranus age is: " + seconds / EarthSeconds / UranusSeconds);
	        System.out.println("Neptune age is: " + seconds / EarthSeconds / NeptuneSeconds);
	}
}
