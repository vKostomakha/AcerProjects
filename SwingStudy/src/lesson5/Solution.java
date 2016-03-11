package lesson5;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 11.03.2016.
 */
public class Solution {

    public static void main(String[] args) throws InterruptedException {

        JFrame window = new JFrame("Форма урока 4");

        window.setSize(600, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(new GridBagLayout());
        window.setVisible(true);


        JProgressBar pBar = new JProgressBar();
        JLabel label = new JLabel();

        label.setText("Загрузка...");


        pBar.setStringPainted(true);
//        pBar.setIndeterminate(true);

        pBar.setMinimum(0);
        pBar.setMaximum(100);

        window.add(pBar);
        window.add(label);

        for (int i = pBar.getMinimum(); i <= pBar.getMaximum(); i++) {
            Thread.sleep(100);
            pBar.setValue(i);

        }

        label.setText("Загружено");

        Thread.sleep(1000);
        window.setVisible(false);
        window.dispose();
        System.exit(0);


    }
}
