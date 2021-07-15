/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Esper;
import events.speedSensorReading;
import events.transmission;
import view.*;

/**
 *
 * @author seif165937
 */
public class transmitter extends Thread {

    private int segmentID;
    private boolean signalStatus;
    private int speedLimit;
    private transmiterView GUI;

    public transmitter() {
        // making the GUI visible
        GUI = new transmiterView();
        GUI.setLocationRelativeTo(null);
        GUI.setVisible(true);
    }

    //update the readings and capturing them using Esper
    public void sendReadings(int segID, boolean status, int maxSpeed) {
        Esper.sendEvent(new transmission(segID, status, maxSpeed));
    }

    //vollecting from the GUI
    public void collectReadings() {

        //get segment ID
        String tempID = GUI.getSegID().getText();
        segmentID = Integer.parseInt(tempID);

        //get Speed Limit
        String tempSpeed = GUI.getMaxSpeed().getText();
        speedLimit = Integer.parseInt(tempSpeed);

        //get the toggle button status
        if (GUI.getSignalStatus().isSelected()) {
            signalStatus = true;
        } else {
            signalStatus = false;
        }

        System.out.println(" ////////////// \n -> Incoming Transmission <- \n Speed Limit: " + speedLimit + " \n RED signal: " + signalStatus + "\n seg ID: " + segmentID + " \n //////////"); //testing
    }

    @Override
    public void run() {
        while (true) {

            try {
                
               
                collectReadings();
                 this.sleep(50); //50 msec to send the readings
                sendReadings(segmentID, signalStatus, speedLimit);

                this.sleep(5000);
            } catch (InterruptedException ex) {

            }

        }
    }

    public void setSegmentID(int segmentID) {
        this.segmentID = segmentID;
    }

    public void setSignalStatus(boolean signalStatus) {
        this.signalStatus = signalStatus;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getSegmentID() {
        return segmentID;
    }

    public boolean isSignalStatus() {
        return signalStatus;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

}
