package com.revature.challenged2;

//Abstraction demonstration
class Toyota implements CarNeeds
{
    // Implementing the capabilities of
    // interface.
    public void inflatedWheels()
    {
        System.out.println("Wheels are inflated");
    }
    
    public void movingSpeed() {
    	System.out.println("Velocity is out of this world.");
    }
 
    // Driver Code
    public static void main (String[] args)
    {
        Toyota t = new Toyota();
        t.inflatedWheels();
        t.movingSpeed();
    }
}