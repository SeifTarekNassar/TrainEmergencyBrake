/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seif165937
 */
public class powerKnob extends Thread  {

 private final Train train;

    public powerKnob(Train train) {
        this.train = train;
    }

 
    
      @Override
    public void run() {
        while (true) {
              try {
            if (train.getPower() > 0 && train.getCurrentSpeed() < 181  && train.isBraking() == false) {
                
                train.getSpeedSensor().accelerate(train.getPower());
            } else if(train.getPower() == 0){
              train.getSpeedSensor().idle();
            }
          
                this.sleep(1000);
            } catch (InterruptedException ex) {
              
            }
        }
    }



    
}
