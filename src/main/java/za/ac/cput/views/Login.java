package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {
    private static JFrame frame;
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passLabel;
    private static JPasswordField passwordField;
    private static JButton button;
    private static JLabel result;

    private static User user;

    public static void main(String[] args) {
        frame = new JFrame("Hospital Management");
        JPanel panel = new JPanel();

        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 17);
        Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 10);

        frame.setSize(310, 170);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.black);

        userLabel = new JLabel("User Name");
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(10, 20, 80, 25);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);

        passLabel = new JLabel("Password");
        passLabel.setBounds(10, 50, 80, 25);
        passLabel.setForeground(Color.WHITE);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);

        button = new JButton("Login");
        button.setForeground(Color.BLACK);
        button.setBackground(Color.white);
        button.setBounds(100, 80, 80, 25);

        result = new JLabel(" ");
        result.setBounds(100, 105, 300, 25);

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passwordField);
        panel.add(button);
        panel.add(result);

        button.addActionListener(new Login());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = userText.getText();
        String password = String.valueOf(passwordField.getPassword());
        if (userName.equals("admin-user") && password.equals("65ff7492d30")) {
            result.setText("Logged in Successfully!");
            result.setForeground(new Color(24, 161, 95));
            frame.dispose();
            adminMain admin = new adminMain();
            admin.showGUI();
        } else if (userName.equals("client") && password.equals("1253208465b")) {
            result.setText("Logged in Successfully!");
            result.setForeground(new Color(24, 161, 95));
            frame.dispose();
            User user = new User();
            user.setGUI();
        } else if (userName.equals("") || password.equals("")) {
            result.setText("Please Fill out all fields.");
            result.setForeground(new Color(17, 120, 171));
        } else {
            result.setText("Incorrect details!");
            result.setForeground(Color.red);
        }
    }
}
