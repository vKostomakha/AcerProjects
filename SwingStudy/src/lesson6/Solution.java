package lesson6;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 11.03.2016.
 */
public class Solution {

    public static void main(String[] args) throws InterruptedException {

        JFrame window = new JFrame("Форма урока 6");

        window.setSize(600, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(new GridBagLayout());
        window.setVisible(true);

        JPanel content = new JPanel();

        JButton tButton = new JButton("TEST");

        content.setBackground(Color.cyan);

        window.setContentPane(content);

    }

}
