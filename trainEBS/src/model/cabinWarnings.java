/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.applet.AudioClip;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.applet.Applet;

/**
 *
 * @author seif165937
 */
public class cabinWarnings {

    private Train train;

    public cabinWarnings(Train train) {
        this.train = train;
    }

    public void soundWarning() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    AudioClip clip = Applet.newAudioClip(getClass().getResource("../audio/RedAlert1.wav"));
                    clip.play();
 Thread.sleep(1000);
                    //System.out.println("sound warning test test !!");
                } catch (Exception ex) {

                }
            }

        }).start();

    }

    public void overSpeedWarning() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                //System.out.println(" warning test test !!");
                try {

                    train.getGUI().getOverSpeedText().setBackground(java.awt.Color.RED);
                    train.getGUI().getOverSpeedText().setText("OverSpeed");
                    train.getGUI().getWarrningTextOne().setBackground(java.awt.Color.RED);
                    train.getGUI().getSpeedText().setForeground(java.awt.Color.RED);

                    Thread.sleep(500);

                    train.getGUI().getOverSpeedText().setBackground(java.awt.Color.white);
                    train.getGUI().getWarrningTextOne().setBackground(java.awt.Color.white);
                    train.getGUI().getSpeedText().setForeground(java.awt.Color.GREEN);
                    train.getGUI().getOverSpeedText().setText(" ");
                } catch (Exception ex) {

                }
            }

        }).start();

    }

    public void RedLightWarning() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                //System.out.println(" warning test test !!");
                try {
                    train.getGUI().getWarrningTextTwo().setBackground(java.awt.Color.RED);
                    train.getGUI().getWarrningTextTwo().setText("Red Signal Ahead");
                    train.getGUI().getWarrningTextOne().setBackground(java.awt.Color.RED);
                    Thread.sleep(500);
                    train.getGUI().getWarrningTextOne().setBackground(java.awt.Color.white);
                    train.getGUI().getWarrningTextTwo().setBackground(java.awt.Color.white);
                    train.getGUI().getWarrningTextTwo().setText(" ");
                } catch (Exception ex) {

                }
            }

        }).start();

    }

}
