/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.concurrent.ThreadLocalRandom;
import events.speedSensorReading;
import esper.Esper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seif165937
 */
public class SpeedSensor extends Thread {

    private Train train;
    private int speed;
    private static int tempSpeed;

    public SpeedSensor(Train tr) {
        this.train = tr;
        this.speed = 0;
        this.tempSpeed = speed;
    }

    private int generateRandom(int min, int max) {

        int randomWithThreadLocalRandomFromZero = ThreadLocalRandom.current().nextInt((max - min) + 1);

        return randomWithThreadLocalRandomFromZero + min;
    }

    public void accelerate(int power) {

        // System.out.println("model.SpeedSensor.accelerate() anaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+power); //testing
        if (speed <= train.getMaxSpeed()) {
            switch (power) {
                case 25:
                    speed += generateRandom(1, 4);
                    tempSpeed = speed;
                    break;
                case 50:
                   // System.out.println("speed at cruise is " + tempSpeed); //testing statement
                    if(speed ==0)
                        speed++;
                    if (speed >= tempSpeed + 1) {
                        speed -= generateRandom(1, 2);
                    } else if (speed < tempSpeed + 2) {
                        speed += generateRandom(1, 3);
                    }
                    break;
                case 75:
                    speed += generateRandom(5, 6);
                    tempSpeed = speed;
                    break;
                case 100:
                    speed += generateRandom(9, 15);
                    tempSpeed = speed;
                    break;

            }
        }
    }

    public void EmergencyBrake() {
        try {
            int temp = generateRandom(2, 5);
            speed -= temp;
            tempSpeed -= temp;

            train.displaySpeed(speed);
            Esper.sendEvent(new speedSensorReading(speed));
            Thread.sleep(2000);
            // System.out.println("model.SpeedSensor.EmergencyBrake()"); //testing
        } catch (InterruptedException ex) {
            System.out.println("exceptionnnnnnn");
            System.out.println(ex);
        }

    }

    public void idle() {
        if (speed > 0 && speed != 0) {

            speed -= generateRandom(4, 7);
            if (speed < 0) {
                speed = 0;
            }
        } else {
            speed = 0;
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.sleep(250);

                if (speed <= train.getMaxSpeed()) {
                    Esper.sendEvent(new speedSensorReading(speed));
                    train.displaySpeed(speed);
                } else {
                    speed = train.getMaxSpeed();
                    Esper.sendEvent(new speedSensorReading(speed));
                }
            } catch (InterruptedException ex) {

            }
        }
    }

}
