package CALCULATOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame implements ActionListener {
    JTextField input;
    JButton[] number=new JButton[10];
    JButton[] function =new JButton[8];
    JButton add,sub,mul,div;
    JButton dot, equal, clear, close;
    JPanel panel;



    double nun1=0,num2=0,result=0;
    char op;

    calculator(){
        super ("CALCULATOR");

        //heading
        JLabel head=new JLabel("CALCULATOR");
        head.setFont(new Font("Arial",Font.BOLD,40));
        head.setBounds(63,20,300,40);
        head.setForeground(new Color(29,120,182));
        add(head);

        //textfield
        input=new JTextField(20);
        input.setFont(new Font("Arial",Font.BOLD,30));
        input.setBounds(50,75,300,50);
        input.setForeground(Color.WHITE);
        input.setBackground(new Color(21,36,68));
        input.setEditable(false);
        add(input);

        //button
        add=new JButton("+");
        sub=new JButton("-");
        div=new JButton("÷");
        mul=new JButton("x");
        dot=new JButton(".");
        equal=new JButton("=");
        close =new JButton("CLOSE");
        clear=new JButton("CLEAR");

        function [0]=add;
        function [1]=sub;
        function [2]=div;
        function [3]=mul;
        function [4]=dot;
        function [5]=equal;
        function [6]= close;
        function [7]=clear;

        for(int i=0;i<8;i++){
            function [i].addActionListener(this);
            function[i].setFont(new Font("Arial",Font.BOLD,20));
            function[i].setBackground(new Color(109,196,255));
            function[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            number[i]=new JButton(String.valueOf(i));
            number[i].addActionListener(this);
            number[i].setFont(new Font("Arial",Font.BOLD,20));
            number[i].setFocusable(false);
        }

        close.setBounds(50,480,145,50);
        add(close);
        clear.setBounds(205,480,145,50);
        add(clear);

        panel=new JPanel();
        panel.setBounds(50,150,300,300);
        panel.setLayout(new GridLayout(4,4));
        panel.setBackground(Color.darkGray);
        add(panel);

        panel.add(number[1]);
        panel.add(number[2]);
        panel.add(number[3]);
        panel.add(function[0]);

        panel.add(number[4]);
        panel.add(number[5]);
        panel.add(number[6]);
        panel.add(function[1]);

        panel.add(number[7]);
        panel.add(number[8]);
        panel.add(number[9]);
        panel.add(function[3]);

        panel.add(function[4]);
        panel.add(number[0]);
        panel.add(function[2]);
        panel.add(function[5]);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("CALCULATOR/background.png"));
        Image i2= i1.getImage().getScaledInstance(415,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel bg=new JLabel(i3);
        bg.setBounds(550,100,415,600);
        add(bg);
        //getContentPane().setBackground(new Color(0,0,0));
        //setLayout(null);
        setBounds(750,200,415,600);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent a) {
        try {
            for(int i=0;i<10;i++){
                if(a.getSource()== number[i]){
                    input.setText(input.getText().concat(String.valueOf(i)));
                }
            }
            if (a.getSource()==dot){
                input.setText(input.getText().concat("."));
            }
            else if (a.getSource()==add){
                nun1=Double.parseDouble(input.getText());
                op='+';
                input.setText("");
            }
            else if (a.getSource()==sub){
                nun1=Double.parseDouble(input.getText());
                op='-';
                input.setText("");
            }
            else if (a.getSource()==div){
                nun1=Double.parseDouble(input.getText());
                op='/';
                input.setText("");
            }
            else if (a.getSource()==mul){
                nun1=Double.parseDouble(input.getText());
                op='x';
                input.setText("");
            }
            else if (a.getSource()==equal) {
                num2=Double.parseDouble(input.getText());
                switch (op){
                    case '+':
                        result=nun1+num2;
                        break;
                    case '-':
                        result=nun1-num2;
                        break;
                    case '/':
                        result=nun1/num2;
                        break;
                    case 'x':
                        result=nun1*num2;
                        break;
                }
                input.setText(String.valueOf(result));
                double num1 = result;
            }
            else if (a.getSource()==clear){
                input.setText("");
            }else if (a.getSource()== close){
                JOptionPane.showMessageDialog(null,"**THANK YOU FOR USING MY CALCULATOR**");
                setVisible(false);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new calculator();
    }

}