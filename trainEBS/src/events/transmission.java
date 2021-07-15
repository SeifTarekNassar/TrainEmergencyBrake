/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author seif165937
 */
public class transmission {
     private  int segmentID ;
     private boolean signalStatus ;
     private int speedLimit;

    public transmission(int segID , boolean status , int speed) {
    
    this.segmentID = segID;
    this.signalStatus = status;
    this.speedLimit = speed;
    }

     
     
     
     
     
     
     
     
    public int getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(int segmentID) {
        this.segmentID = segmentID;
    }

   

    public boolean isSignalStatus() {
        return signalStatus;
    }

    public void setSignalStatus(boolean signalStatus) {
        this.signalStatus = signalStatus;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
     
     
     
     
     
     
     
     
     
     
}
