package javaCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// A simple calculator implementation using Swing
public class myCalculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JPanel panel;
    // addition, subtraction, multiply, division buttons
    JButton addButton, subButton, mulButton, divButton;
    // decimal, equals, delete, clear, negative buttons.
    JButton decButton, equButton, delButton, clrButton, negButton;

    // Font for calculator buttons and text field
    Font myCalcFont = new Font("Arial", Font.PLAIN, 24);
    double result = 0;
    double num1 = 0, num2 = 0;
    char operator;

    // Constructor to initialize the calculator
    myCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myCalcFont);
        textfield.setEditable(false);

        for (int i = 0; i < 10; ++i) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myCalcFont);
            numberButtons[i].setFocusable(false);
        }

        // Create function buttons
        addButton = createButton("+");
        subButton = createButton("-");
        mulButton = createButton("*");
        divButton = createButton("/");
        decButton = createButton(".");
        equButton = createButton("=");
        delButton = createButton("DEL");
        clrButton = createButton("C");

        negButton = createButton("(-)");

        // Add function buttons to the array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Initialize function buttons
        for (int i = 0; i < 9; ++i) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myCalcFont);
            functionButtons[i].setFocusable(false);
        }

        // Create panel to hold buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.WHITE);

        // Add buttons to the panel
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(negButton);
        panel.add(divButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);

        // Add components to the frame
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }

    // Main method to start the calculator
    public static void main(String[] args) {
        myCalculator calc = new myCalculator();
    }

    // Action listener method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Action handling remains the same
    }

    // Utility method to create buttons
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.setFont(myCalcFont);
        button.setFocusable(false);
        return button;
    }
}

