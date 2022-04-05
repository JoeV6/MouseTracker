package com.LPC1;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class ROBOT implements Runnable {
    @Override
    public void run() {
        GUI.BOT = false;
        GUI.ESCOUT = true;
        while (GUI.AMOUNT > 0 && GUI.ESCOUT) {
            try {
                Robot robot = new Robot(); //make new robot
                robot.mouseMove(CheckAction.coordinatesX.get(GUI.CORDS), CheckAction.coordinatesY.get(GUI.CORDS)); //replay mouse movements
                GUI.AMOUNT--;
                GUI.CORDS++;
            } catch (AWTException ignored) {
            }

            try {
                TimeUnit.MILLISECONDS.sleep(GUI.TIMEOUTTIME); //wait for TIMEOUTTIME milliseconds between movements
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        GUI.BOT = true;
        GUI.AMOUNT = GUI.TEMP;  //reset cords
        GUI.CORDS = 0;          //reset cord amount

        System.out.println("Finished");

    }
}

