/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import model.Train;
import esper.Esper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author seif165937
 */
public class Run {

    public static void main(String[] args) {
        Logger.getRootLogger().setLevel(Level.OFF);

        // Register events
        Esper.registerEvents();

        final Train trainObj = new Train();

        //speed
        Esper.createStatement("select speed from speedSensorReading")
                .setSubscriber(new Object() {
                    public void update(int sp) {

                        trainObj.setCurrentSpeed(sp);

                    }
                });

        //power
        Esper.createStatement("select powerReading from powerKnobReading ")
                .setSubscriber(new Object() {
                    public void update(int reading) {

                        trainObj.setPower(reading);
        // System.out.println("power is set to  "+reading); //testing
                    }
                });

        //transmissions 
        Esper.createStatement("select  segmentID from transmission")
                .setSubscriber(new Object() {
                    public void update(int segID) {

                        trainObj.setSegID(segID);
                        trainObj.displaySegID(segID);
                        //  System.out.println("gggggggg"+segID); //testing

                    }
                });

        Esper.createStatement("select   signalStatus from transmission")
                .setSubscriber(new Object() {
                    public void update(boolean SS) {

                        trainObj.setSigStatus(SS);
                        //  System.out.println("gggggggg"+SS); //testing

                    }
                });

        Esper.createStatement("select   speedLimit from transmission")
                .setSubscriber(new Object() {
                    public void update(int sp) {

                        trainObj.setSpeedlimit(sp);
                        trainObj.displaySpeedLimit(sp);
                        // System.out.println("gggggggg"+sp); //testing

                    }
                });

    }

}
