package com.LPC1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame implements Runnable, ActionListener, KeyListener {

    public static boolean ON = false; //declare variables
    public static boolean ESC = false;
    public static boolean BOT = false;
    public static boolean ESCOUT = false;

    public static int AMOUNT = 0;
    public static int CORDS = 0;
    public static int TEMP = 0;

    public static final int TIMEOUTTIME = 20;

    JLabel label;
    JLabel label1;
    JFrame frame;
    JPanel panel;
    public static JButton button;

    @Override
    public void run() {

        System.out.println("Started Mouse"); //println started mouse
        frame = new JFrame(); //make new JFrame


        button = new JButton("Start"); //Button setup
        button.setLayout(null);
        button.addActionListener(this);
        button.addKeyListener(this);
        button.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        button.setSize(100, 100);
        button.setBackground(Color.lightGray);
        button.setContentAreaFilled(true);
        button.setForeground(Color.black);
        button.setBounds(40, 60, 200, 20);


        label = new JLabel("Click To Start"); //Label setup
        label1 = new JLabel("");


        panel = new JPanel(); //Panel setup
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.add(button);
        panel.add(label);
        label.setBounds(10, 20, 400, 20);

        ImageIcon img = new ImageIcon("src/com/LPC1/img.png"); //ImageIcon Setup

        frame = new JFrame(); //Frame Setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) { }    //ON KEYTYPED

    @Override
    public void keyPressed(KeyEvent e) { }  // ON KEYPRESSED

    @Override
    public void keyReleased(KeyEvent e) {   //ON KEYRELEASED

        if ((e.getKeyCode() == 27 && ON)) { //If key == esc and on == true

            ON = false;
            ESC = false;
            BOT = true;

            button.setText("Start");                        //change button text
            System.out.println("STOP CHECK ");
            label.setText("Press To Start Recording Or Press R To Replay");     //change label text

        } else if ((e.getKeyCode() == 27 && ESC)) {         //if key == esc and var ESC == true
            System.out.println("START RECORDING");
            label.setText("Press Esc To Stop Recording");   //change label text



            ON = true;

            CheckAction runnable2 = new CheckAction();      //start new checker thread
            Thread thread2 = new Thread(runnable2);         //start new checker thread
            thread2.start();                                //start new checker thread

        } else if ((e.getKeyCode() == 82 && BOT)) {         //if key == r and BOT == true
            ROBOT runnable3 = new ROBOT();                  //start new bot thread
            Thread thread3 = new Thread(runnable3);         //start new bot thread
            thread3.start();                                //start new bot thread

        } else if ((e.getKeyCode() == 27 && ESCOUT)) {      //if key == esc and ESCOUT == true

            ESCOUT = false;
            BOT = true;                                     //stop robot

            AMOUNT = TEMP;                                  //reset amount with temp variable
            CORDS = 0;                                      //reset cord amount
            System.out.println("Stopped");

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {                          //when button is clicked

            if (!ON) {
                button.setText("On");                           //change button text
                label.setText("Press Esc To Start Recording");  //change label text

                CheckAction.coordinatesX.clear();
                CheckAction.coordinatesY.clear();

                CORDS = 0;
                AMOUNT = 0;
                TEMP = 0;

                BOT = false;
                ESC = true;

                System.out.println("START CHECK");
            }
        }
    }
}

