// Grant Tannert
// Mouse is the class that creates the Interactive GUI aspect of this program
// which deals with the mouse interaction and the frame/panel/label display.

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Mouse implements MouseListener {

    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    private String pathImage;
    private String textResult;

    public Mouse (String pathImage, String textResult) {
        this.pathImage = pathImage;
        this.textResult = textResult;

        // setting up the label
        ImageIcon mysteryBox = new ImageIcon(new ImageIcon("mystery.png").getImage()
                               .getScaledInstance(150, 150, java.awt.Image.
                               SCALE_SMOOTH));
        label = new JLabel("Click me once for a surprise", mysteryBox, JLabel.CENTER);
        changeText(20, "MV Boli", Font.BOLD, JLabel.CENTER, JLabel.TOP);

        // setting up the panel
        panel = new JPanel();
        panel.setBounds(150, 70, 300, 300);
        panel.addMouseListener(this);
        panel.setBackground(new Color(51, 0, 111));
        panel.setBorder(BorderFactory.createBevelBorder(0));
        panel.setLayout(new BorderLayout());
        panel.add(label);

        // setting up the frame
        frame = new JFrame("CSE 143X Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(232, 211, 162));
        frame.setIconImage(new ImageIcon("LogoCSE143XCalculator.png").getImage());
        frame.setLayout(null);
        // frame.addMouseListener(this);
        frame.setVisible(true);
        frame.add(panel);
    }

    @Override
    // when user clicks mouse
    public void mouseClicked(MouseEvent e) {
        label.setText("Calculating... Press image for 7s");
        label.setIcon(new ImageIcon("Calculating.gif"));
        changeText(15, "MV Boli", Font.BOLD, JLabel.CENTER, JLabel.TOP);
        panel.setBorder(BorderFactory.createBevelBorder(-1));
    }

    @Override
    // when user presses mouses
    public void mousePressed(MouseEvent e) {
        label.setText(textResult);
        ImageIcon newSize = new ImageIcon(new ImageIcon(pathImage).getImage().getScaledInstance
                                         (250, 200, java.awt.Image.SCALE_DEFAULT));
        label.setIcon(newSize);
        changeText(20, "MV Boli", Font.BOLD, JLabel.CENTER, JLabel.TOP);
    }

    @Override
    // when user releases mouse
    public void mouseReleased(MouseEvent e) {
        System.out.println("You released your mouse");
        label.setText("Thanks for trying out my program ;)");
        ImageIcon logo = new ImageIcon(new ImageIcon("Pika.gif").getImage().getScaledInstance
                                      (250, 200, java.awt.Image.SCALE_DEFAULT));
        label.setIcon(logo);
        changeText(15, "MV Boli", Font.BOLD, JLabel.CENTER, JLabel.TOP);
    }

    @Override
    // when user enters the frame area
    public void mouseEntered(MouseEvent e) {
        ImageIcon mysteryBox = new ImageIcon(new ImageIcon("mystery.png").getImage()
                                            .getScaledInstance(150, 150, java.awt.Image.
                                            SCALE_SMOOTH));
        label.setText("Click me once for a surprise");
        label.setIcon(mysteryBox);
        changeText(20, "MV Boli", Font.BOLD, JLabel.CENTER, JLabel.TOP);
        panel.setBorder(BorderFactory.createBevelBorder(0));
    }

    @Override
    // when user leaves the frame area
    public void mouseExited(MouseEvent e) {
        label.setText("Are you leaving?");
        label.setIcon(new ImageIcon("SadBatFace.gif"));
        changeText(20, "MV Boli", Font.BOLD, JLabel.CENTER, JLabel.TOP);
        panel.setBorder(BorderFactory.createBevelBorder(0));
    }
    
    // change font size; font type; textEdit: Italics, Bold...; horizontal & vertical
    // text position relative to the image
    private void changeText(int fontSize, String font, int textEdit, 
                            int horizontal, int vertical) {
        label.setHorizontalTextPosition(horizontal);
        label.setVerticalTextPosition(vertical);
        label.setForeground(new Color(145, 123, 76));
        label.setFont(new Font(font, textEdit, fontSize));
    }

}
