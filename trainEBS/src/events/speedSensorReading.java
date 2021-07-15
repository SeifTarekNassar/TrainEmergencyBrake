/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author falcon
 */
public class speedSensorReading {
       private final int speed;
    
    public speedSensorReading(int speed)
    {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    

}
