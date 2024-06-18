import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static char operator = ' ';

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Calculator");

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel first_number = new JLabel("First Number: ");
        first_number.setBounds(70, 30, 200, 50);

        JTextField txtfirst_number = new JTextField();
        txtfirst_number.setBounds(200, 30, 200, 50);

        JLabel second_number = new JLabel("Second Number: ");
        second_number.setBounds(70, 100, 200, 50);

        JTextField txtsecond_number = new JTextField();
        txtsecond_number.setBounds(200, 100, 200, 50);

        JLabel result_number = new JLabel("Result: ");
        result_number.setBounds(70, 170, 200, 50);

        JTextField txtresult_number = new JTextField();
        txtresult_number.setBounds(200, 170, 200, 50);
        txtresult_number.setEditable(false);

        JButton btn_addition = new JButton("+");
        btn_addition.setBounds(50, 250, 50, 50);

        JButton btn_subtraction = new JButton("-");
        btn_subtraction.setBounds(100, 250, 50, 50);

        JButton btn_multiplication = new JButton("*");
        btn_multiplication.setBounds(150, 250, 50, 50);

        JButton btn_division = new JButton("/");
        btn_division.setBounds(200, 250, 50, 50);

        JButton btn_equal = new JButton("=");
        btn_equal.setBounds(250, 250, 50, 50);

        JButton btn_clear = new JButton("Clear");
        btn_clear.setBounds(300, 250, 100, 50);

        btn_addition.addActionListener(e -> operator = '+');
        btn_subtraction.addActionListener(e -> operator = '-');
        btn_multiplication.addActionListener(e -> operator = '*');
        btn_division.addActionListener(e -> operator = '/');

        btn_equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float firstNumber = Float.parseFloat(txtfirst_number.getText());
                float secondNumber = Float.parseFloat(txtsecond_number.getText());
                float result = calculate(firstNumber, secondNumber, operator);
                txtresult_number.setText(String.valueOf(result));
            }
        });

        ActionListener actionListener_clear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtfirst_number.setText("");
                txtsecond_number.setText("");
                txtresult_number.setText("");
            }
        };
        btn_clear.addActionListener(actionListener_clear);

        frame.setLayout(null);

        frame.add(first_number);
        frame.add(txtfirst_number);

        frame.add(second_number);
        frame.add(txtsecond_number);

        frame.add(result_number);
        frame.add(txtresult_number);

        frame.add(btn_addition);
        frame.add(btn_subtraction);
        frame.add(btn_multiplication);
        frame.add(btn_division);
        frame.add(btn_equal);
        frame.add(btn_clear);

        frame.setVisible(true);
    }

    private static float calculate(float firstNumber, float secondNumber, char operator) {
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0) {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero.");
                    return 0;
                }
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }
}
