package com.company;


import com.j4ev3.core.Brick;
import com.j4ev3.core.Motor;
import com.j4ev3.desktop.BluetoothComm;

import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

/*public class SimpleGUI extends JFrame{
    JFrame window=new JFrame();
    private JButton btn1 = new JButton("Vpered");

    private JButton btn2 = new JButton("Nazad");
    private JButton btn3 = new JButton("Vbpravo");
    private JButton btn4 = new JButton("Vlevo");
}*/
public class Main {
    public static class SimpleGUI {
        JFrame f;

        SimpleGUI(Brick brick) {

            Thread a = new Thread(() -> shutdown(brick));
            Runtime.getRuntime().addShutdownHook(a);

            JFrame f = new JFrame();
            f.setLayout(null);
            f.setVisible(true);
            f.setSize(500,500);
            f.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(KeyEvent.VK_UP == e.getKeyCode()){
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_A + Motor.PORT_D), -100);
                    }else if(KeyEvent.VK_DOWN == e.getKeyCode()){
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_A + Motor.PORT_D), 100);
                    }else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_A ), 5);
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_D ), -50);
                    }else if(KeyEvent.VK_LEFT == e.getKeyCode()){
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_D), 5);
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_A ), -50);
                    }else if(KeyEvent.VK_SPACE == e.getKeyCode()){
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_D), 0);
                        brick.getMotor().turnAtPower((byte) (Motor.PORT_A ), 0);
                    }else if(KeyEvent.VK_BACK_SPACE == e.getKeyCode()){
                        System.exit(0);
                    }
                }
            });
            JButton btnClose= new JButton("Close App");
            f.add(btnClose);
            btnClose.setVisible(true);
            btnClose.setBounds(0, 300, 300, 100);
            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   System.exit(0);
                }
            });
            JButton btn1 = new JButton("Vpered");
            f.add(btn1);
            btn1.setVisible(true);
            btn1.setBounds(100, 0, 100, 100);
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    brick.getMotor().turnAtPower((byte) (Motor.PORT_A + Motor.PORT_D), -50);
                }
            });
            JButton btn2 = new JButton("Nazad");
            f.add(btn2);
            btn2.setVisible(true);
            btn2.setBounds(100, 100, 100, 100);
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    brick.getMotor().turnAtPower((byte) (Motor.PORT_A + Motor.PORT_D), 50);
                }
            });
            JButton btn3 = new JButton("Stop");
            f.add(btn3);
            btn3.setVisible(true);
            btn3.setBounds(300, 300, 100, 100);
            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    brick.getMotor().turnAtPower((byte) (Motor.PORT_A + Motor.PORT_D), 0);

                }
            });
            JButton btn4 = new JButton("Vpravo");
            f.add(btn4);
            btn4.setVisible(true);
            btn4.setBounds(200, 100, 100, 100);
            btn4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    brick.getMotor().turnAtPower((byte) (Motor.PORT_A ), 5);
                    brick.getMotor().turnAtPower((byte) (Motor.PORT_D ), -50);
                }
            });
            JButton btn5 = new JButton("Vlevo");
            f.add(btn5);
            btn5.setVisible(true);
            btn5.setBounds(0, 100, 100, 100);
            btn5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    brick.getMotor().turnAtPower((byte) (Motor.PORT_D ), 5);
                    brick.getMotor().turnAtPower((byte) (Motor.PORT_A ), -50);
                }
            });

        }
    }


    public static void main(String[] args) {

        Brick brick = new Brick(new BluetoothComm("0016534d62bc"));
        new SimpleGUI(brick);



    }

    private static void shutdown(Brick brick) {

        brick.getMotor().turnAtPower((byte) (Motor.PORT_A + Motor.PORT_D), 0);
        brick.disconnect();
    }
}

