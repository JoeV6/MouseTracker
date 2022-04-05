package com.LPC1;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CheckAction implements Runnable {

    public static ArrayList<Integer> coordinatesX = new ArrayList<Integer>();
    public static ArrayList<Integer> coordinatesY = new ArrayList<Integer>();

    @Override
    public void run() {

            while (true) {

                if (GUI.ON) {

                    Point XY = MouseInfo.getPointerInfo().getLocation();    //check mouse location
                    int x = (int) XY.getX();
                    int y = (int) XY.getY();

                    coordinatesX.add(x);                                    //put in variables
                    coordinatesY.add(y);
                    GUI.AMOUNT++;
                    GUI.TEMP++;


                    System.out.println(" CORDS (" + x + "," + y + ")");


                    try {
                        TimeUnit.MILLISECONDS.sleep(GUI.TIMEOUTTIME);            //wait 10 milliseconds between each saved mouse position
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

