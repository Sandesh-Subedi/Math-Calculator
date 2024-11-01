package javaCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A simple calculator implementation using Swing
public class MyCalculator implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[9];
    private JPanel panel;

    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton, negButton;

    private Font myCalcFont = new Font("Helvetica", Font.BOLD, 22);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Constructor to initialize the calculator
    public MyCalculator() {
        initializeFrame();
        initializeTextField();
        initializeButtons();
        initializePanel();
        frame.setVisible(true);
    }

    // Main method to start the calculator
    public static void main(String[] args) {
        new MyCalculator();
    }

    // Initialize the main frame
    private void initializeFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(43, 43, 43));
    }

    // Initialize the text field
    private void initializeTextField() {
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myCalcFont);
        textField.setEditable(false);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);
    }

    // Initialize all buttons
    private void initializeButtons() {
        for (int i = 0; i < 10; ++i) {
            numberButtons[i] = createButton(String.valueOf(i), new Color(68, 68, 68), Color.WHITE);
        }

        addButton = createButton("+", new Color(255, 153, 0), Color.WHITE);
        subButton = createButton("-", new Color(255, 153, 0), Color.WHITE);
        mulButton = createButton("*", new Color(255, 153, 0), Color.WHITE);
        divButton = createButton("/", new Color(255, 153, 0), Color.WHITE);
        decButton = createButton(".", new Color(255, 153, 0), Color.WHITE);
        equButton = createButton("=", new Color(34, 139, 34), Color.WHITE);
        delButton = createButton("DEL", new Color(220, 20, 60), Color.WHITE);
        clrButton = createButton("C", new Color(220, 20, 60), Color.WHITE);
        negButton = createButton("(-)", new Color(255, 153, 0), Color.WHITE);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
    }

    // Initialize the panel and add buttons to it
    private void initializePanel() {
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(new Color(43, 43, 43));

        addButtonsToPanel();
        frame.add(panel);
    }

    // Add buttons to the panel
    private void addButtonsToPanel() {
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
    }

    // Action listener method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Decimal button
        if (source == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        // Function buttons
        if (source == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (source == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (source == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (source == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (source == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            // Format result to avoid ".0" if it's an integer
            if (result == (long) result) {
                textField.setText(String.valueOf((long) result));
            } else {
                textField.setText(String.valueOf(result));
            }
            num1 = result;
        }

        // Clear button
        if (source == clrButton) {
            textField.setText("");
        }

        // Delete button
        if (source == delButton) {
            String str = textField.getText();
            textField.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textField.setText(textField.getText() + str.charAt(i));
            }
        }

        // Negative button
        if (source == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

    // Utility method to create buttons with custom colors
    private JButton createButton(String label, Color bgColor, Color fgColor) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.setFont(myCalcFont);
        button.setFocusable(false);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        return button;
    }
}
