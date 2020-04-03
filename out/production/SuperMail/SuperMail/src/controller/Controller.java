package controller;

import javax.swing.*;
public class Controller {
    public static void main(String[] args) {
        JFrame frame=new JFrame();

        JButton b=new JButton("does it work?");
        b.setBounds(130,100,300, 40);

        frame.add(b);

        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}  