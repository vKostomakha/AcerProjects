package paintSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

/**
 * Created by Admin on 09.03.2016.
 */
public class PaintSipmple extends JPanel implements MouseListener, MouseMotionListener, ActionListener {


    public Color getCurrentColor() {
        return currentColor;
    }

    private Color currentColor = Color.black;
    private int prevX, prevY;
    private boolean dragging;
    private Graphics graphics;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    private JLabel label = null;

    private static Color[] color = new Color[6];


    public PaintSipmple() {
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton action = (JButton) e.getSource();
        if (action.getBackground() == Color.WHITE)
            repaint();
        else {
            currentColor = action.getBackground();
//            label.setForeground(currentColor);
//            label.setText(getColorName(currentColor));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        int width = getWidth();
        int height = getHeight();

        if (dragging)
            return;

        if (x > 3 && x < width && y > 50 && y < height - 3) {

            prevX = x;
            prevY = y;

            dragging = true;
            graphics = getGraphics();
            graphics.setColor(currentColor);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (!dragging)
            return;

        dragging = false;

        graphics.dispose();
        graphics = null;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (!dragging)
            return;

        int x = e.getX();
        int y = e.getY();


        if (y < 50)
            y = 50;


        graphics.drawLine(prevX, prevY, x, y);

        prevX = x;
        prevY = y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {

        final int width = 60;
        final int height = 30;


        JFrame window = new JFrame("Sveint");
        PaintSipmple content = new PaintSipmple();

        content.setLayout(null);

        window.setContentPane(content);
        ImageIcon image = new ImageIcon("d:\\sveta.jpg");
        window.setIconImage(image.getImage());
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton[] colorButtons = new JButton[6];

//        content.setLabel(new JLabel(getColorName(content.getCurrentColor())));
//
//        content.getLabel().setBounds(350, 210, 200, 100);
//        content.getLabel().setFont(new Font("Comic Sans MS", Font.BOLD, 40));
//        content.getLabel().setForeground(content.getCurrentColor());
//        content.add(content.getLabel());

        color[0] = Color.YELLOW;
        color[1] = Color.blue;
        color[2] = Color.black;
        color[3] = Color.green;
        color[4] = Color.MAGENTA;
        color[5] = Color.RED;

        Rectangle rec = new Rectangle(width, height);


        for (int i = 0; i < colorButtons.length; i++) {
            colorButtons[i] = new JButton();
            colorButtons[i].setBounds(rec);

            colorButtons[i].setBackground(color[i]);
            colorButtons[i].setBounds(rec);

            if (i == 0)
                colorButtons[i].setLocation(10, 10);
            else
                colorButtons[i].setLocation(colorButtons[i - 1].getX() + 10 + width, colorButtons[i - 1].getY());

            colorButtons[i].addActionListener(content);
            content.add(colorButtons[i]);
        }

        JButton cancelButton = new JButton("Clr");
        cancelButton.setBounds(rec);
        cancelButton.setLocation(colorButtons[colorButtons.length - 1].getX() + 10 + width, colorButtons[colorButtons.length - 1].getY());
        cancelButton.addActionListener(content);
        cancelButton.setBackground(Color.white);


        content.add(cancelButton);

        window.setVisible(true);


    }


    private static String getColorName(Color c) {
        for (Field f : Color.class.getFields()) {
            try {
                if (f.getType() == Color.class && f.get(null).equals(c)) {
                    return f.getName();
                }
            } catch (java.lang.IllegalAccessException e) {
                // it should never get to here
            }
        }
        return "unknown";
    }


}
