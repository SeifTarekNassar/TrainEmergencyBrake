/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author seif165937
 */
public class BrakeSensor extends Thread {

    private Train train;

    int trainSpeed;
    int segmentSpeed;
    boolean redSignal;

    public BrakeSensor(Train train) {
        this.train = train;
    }

    @Override
    public void run() {
        while (true) {
            try {
                  this.sleep(100);
                trainSpeed = train.getCurrentSpeed();
                segmentSpeed = train.CurrentSegSpeedLimit();
                redSignal = train.signalStatus(); // danger danger !

                if (redSignal == true && trainSpeed != 0) {
                    train.moveKnob(0);
                    train.Warn().soundWarning();
                    train.Warn().RedLightWarning();
                    
                } else if (trainSpeed > segmentSpeed) {

                    //intiate soft warning
                    //here the voice warrning is invoked 
                    if (trainSpeed > segmentSpeed + 5) {
                        train.Warn().soundWarning();

                        System.out.println("System: WARNING WARNING !");

                    }
                    //intiate speed adjusting 
                    if (trainSpeed >= segmentSpeed + 10 || train.isBraking()) {
                        train.moveKnob(50);
                        train.setBraking(true);
                        train.Warn().overSpeedWarning();
                        //System.out.println("train speed is " + trainSpeed); //testing
                        System.out.println("System: i will slow you down NOW !");
                        train.getSpeedSensor().EmergencyBrake();

                    }

                }
                if (trainSpeed <= segmentSpeed) {
                    train.setBraking(false);
                }

              
            } catch (InterruptedException ex) {

            }
        }
    }

}
