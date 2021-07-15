/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jdk.nashorn.internal.runtime.regexp.joni.Warnings;
import view.dashboared;

/**
 *
 * @author seif165937
 */
public class Train {

    //GUI
    private dashboared GUI;

    //Train readings and Info
    private int maxSpeed = 180;
    private int power = 0;
    private int currentSpeed;

    //Brake status
    private boolean Braking = false;
    
    private final transmitter transmission;

    // The components of the train
    private SpeedSensor speedSensor;
    private powerKnob PowerKnob;
    private BrakeSensor brakeSensor;
    private cabinWarnings warning;

    public Train() {

        // making the GUI visible
        GUI = new dashboared();
        GUI.setLocationRelativeTo(null);
        GUI.setVisible(true);

        
        //intiating new instances of the components
        transmission = new transmitter();
        warning = new cabinWarnings(this);
        PowerKnob = new powerKnob(this);
        speedSensor = new SpeedSensor(this);
        brakeSensor = new BrakeSensor(this);

        //starting threads =)
        PowerKnob.start();
        speedSensor.start();
        transmission.start();
        brakeSensor.start();

    }

    public void displaySpeed(int speed) {
        System.out.println("The speed is now " + speed + " km/h");
        GUI.getSpeedText().setText(speed + " Km/h");

    }

    
   
    
   public void moveKnob(int powervalue){
         this.power = powervalue;
   GUI.getPowerSlider().setValue(powervalue);
 
   } 
   
   
   public void displaySpeedLimit(int tempSpeedLimit){
   
   GUI.SpeedLimit().setText(" "+tempSpeedLimit);
   
   }
   
   public void displaySegID(int tempID){
   
   GUI.SegID().setText(" "+tempID);
   
   }
   
   
   
   
   
   
    public void setBraking(boolean Braking) {
        this.Braking = Braking;
    }
    
    public void setSegID(int segID) {
        this.transmission.setSegmentID(segID);
    }

    public void setSigStatus(boolean status) {
        this.transmission.setSignalStatus(status);
    }

    public void setSpeedlimit(int speed) {
        this.transmission.setSpeedLimit(speed);
    }

    public void setFullTrans(int segID, boolean status, int speed) {
        this.transmission.setSegmentID(segID);
        this.transmission.setSignalStatus(status);
        this.transmission.setSpeedLimit(speed);
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPower(int pwr) {
        this.power = pwr;
    }

    public int getPower() {
        return power;
    }

    public dashboared getGUI() {
        return GUI;
    }

    public SpeedSensor getSpeedSensor() {
        return speedSensor;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isBraking() {
        return Braking;
    }

    
    
    
    
    public powerKnob getPowerKnob() {
        return PowerKnob;
    }

    public BrakeSensor getBrakeSensor() {
        return brakeSensor;
    }
public cabinWarnings Warn(){
return warning;
}
    
    
    //get the transmission info
    public int CurrentSegSpeedLimit(){
    
    return this.transmission.getSpeedLimit();
    }
    
    public boolean signalStatus(){
    return this.transmission.isSignalStatus();
    }
    
    
    
}
