package controller;

import delegates.PackageTrackingDelegate;
import ui.PackageTracking;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Controller implements PackageTrackingDelegate {
    public static void main(String[] args) throws IOException {

        PackageTracking test = new PackageTracking();



        JFrame frame=new JFrame();
        JPanel top = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#534C4B"));
        JLabel logo = new JLabel(new ImageIcon("SuperMail/images/cover.png"));
        logo.setBounds(0,-70,300,200);
        logo.setVisible(true);
        frame.add(logo);

        // icon
        frame.setIconImage(ImageIO.read(new File("SuperMail/images/profile.png")));


        JButton b=new JButton("does it work?");
        b.setBounds(130,100,300, 40);

        frame.add(b);

        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void databaseSetup() {

    }

    @Override
    public void terminalTransactionsFinished() {

    }
}