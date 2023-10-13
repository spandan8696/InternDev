package NumberGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.nio.channels.ScatteringByteChannel;
import java.util.Random;

public class numbergame extends JFrame implements ActionListener {

    JLabel head, head2, head3, text1, text2;

    JTextField textField1, hint;


    JButton show, check, clear;

    int a = 1;
    int b = 100;

    Random rn = new Random();

    int x = rn.nextInt(b - a + 1) + a;


    numbergame() {
        super("NUMBER GAME");

        //icon1
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NumberGame/controlller2.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(20, 15, 100, 100);
        add(icon);

        //icon2
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("NumberGame/controlller2.png"));
        Image iii2 = iii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel icon3 = new JLabel(iii3);
        icon3.setBounds(460, 15, 100, 100);
        add(icon3);

        //label
        head = new JLabel("WELCOME");
        head.setBounds(200, 20, 500, 30);
        head.setForeground(new Color(255, 255, 255));
        head.setFont(new Font("Arial Black", Font.PLAIN, 30));
        add(head);

        //label
        head2 = new JLabel("TO");
        head2.setBounds(265, 50, 500, 30);
        head2.setForeground(new Color(255, 255, 255));
        head2.setFont(new Font("Arial Black", Font.PLAIN, 30));
        add(head2);

        //label
        head3 = new JLabel("NUMBER GAME");
        head3.setBounds(160, 80, 500, 30);
        head3.setForeground(new Color(255, 255, 255));
        head3.setFont(new Font("Arial Black", Font.PLAIN, 30));
        add(head3);

        //label
        text1 = new JLabel("Guess the Number :");
        text1.setBounds(23, 170, 500, 30);
        text1.setForeground(new Color(194, 0, 189));
        text1.setFont(new Font("Arial Black", Font.PLAIN, 30));
        add(text1);

        //label
        text2 = new JLabel("From 1 to 100");
        text2.setBounds(23, 220, 500, 30);
        text2.setForeground(new Color(160, 0, 155));
        text2.setFont(new Font("Arial Black", Font.PLAIN, 25));
        add(text2);

        //text field
        textField1 = new JTextField();
        textField1.setBounds(353, 173, 200, 32);
        textField1.setBackground(new Color(255, 147, 248));
        textField1.setForeground(new Color(62, 28, 76));
        textField1.setFont(new Font("Arial Black", Font.PLAIN, 30));
        add(textField1);

        //button
        check = new JButton("CHECK");
        check.setBounds(220, 300, 150, 50);
        check.setBackground(new Color(237, 158, 238));
        check.setFont(new Font("Arial Black", Font.PLAIN, 25));
        check.setFocusable(false);
        check.addActionListener(this);
        add(check);

        //label
        hint = new JTextField();
        hint.setBounds(65, 370, 450, 150);
        hint.setFont(new Font("Arial Black", Font.PLAIN, 30));
        hint.setOpaque(true);
        hint.setEditable(false);
        hint.setBackground(new Color(127, 29, 142));
        hint.setForeground(new Color(237, 158, 238));
        hint.setHorizontalAlignment(JLabel.CENTER);
        add(hint);

        //button
        show = new JButton("Show the number");
        show.setBounds(65, 570, 230, 50);
        show.setFont(new Font("Arial Black", Font.PLAIN, 20));
        show.setBackground(new Color(237, 158, 238));
        show.addActionListener(this);
        add(show);

        //button
        clear = new JButton("CLEAR");
        clear.setBounds(385, 570, 130, 50);
        clear.setFont(new Font("Arial Black", Font.PLAIN, 20));
        clear.setBackground(new Color(237, 158, 238));
        clear.addActionListener(this);
        add(clear);


        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(61, 33, 78));
        setBounds(700, 100, 600, 700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {


        try {
                int g = Integer.valueOf(textField1.getText());
                int g2 = g - x;

                if (a.getSource() == check) {

                    if (g == x) {
                        hint.setText("correct");
                        JOptionPane.showMessageDialog(null, "CORRECT");
                        setVisible(false);

                        //break;
                    } else if (g > x && -5 <= g2 && g2 <= 5) {
                        hint.setText(g+" is High but close ");


                    } else if (g < x && -5 <= g2 && g2 <= 5) {
                        hint.setText(g+" is low but close");


                    } else if (g > x) {
                        hint.setText(g+" is High and Far too");


                    } else {
                        hint.setText(g+" is Low and Far too");

                    }

                }
                else if (a.getSource() == show) {
                    hint.setText("CORRECT ANSWER = " + x);
                }

                else if (a.getSource() == clear) {
                    textField1.setText("");

                }

            } catch(Exception e){
                e.printStackTrace();
            }
        }


    public static void main(String[] args) {
            new numbergame();
    }
}
