package lesson3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 09.03.2016.
 */
public class JTextFieldTest {

    public static void main(String[] args) {

        JFrame colection = new JFrame("Форма урока 3");

        colection.setSize(600, 450);
        colection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colection.setLocationRelativeTo(null);
        colection.setLayout(new GridBagLayout());

        JButton button = new JButton("Send");
        JTextField textField = new JTextField(30);
        JPasswordField passwordField = new JPasswordField(30);

        textField.setText("FUCK");
        System.out.println(textField.getText());

        textField.setBackground(new Color(11,2,40));

        colection.add(textField);
        colection.add(button);


        colection.setVisible(true);
    }


}
