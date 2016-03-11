package lesson4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 09.03.2016.
 */
public class LabelTest {

    public static void main(String[] args) {


        JFrame window = new JFrame("Форма урока 4");

        window.setSize(600, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Sum info");

        label.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        label.setForeground(Color.blue);
        window.add(label);


        window.setVisible(true);
    }

}
