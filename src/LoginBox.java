import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginBox extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField user, pass;
    public String username, password;
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");
    public boolean LOGIN = false;
    public LoginBox() {
        setSize(300, 150);
        setTitle("Leaderboard Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getRootPane().setDefaultButton(loginButton);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel infoArea = new JPanel(new GridLayout(0, 1));
        infoArea.add(new JLabel("Username: ")).setFont(new Font("Helvetica", Font.PLAIN, 16));
        infoArea.add(new JLabel("Password: ")).setFont(new Font("Helvetica", Font.PLAIN, 16));
        infoArea.setBackground(Color.WHITE);
        contentPane.add(infoArea, BorderLayout.WEST);

        JPanel textPanel = new JPanel(new GridLayout(0, 1));
        // textPanel.setBackground(Color.BLUE);
        user = new JTextField("");
        pass = new JPasswordField("");

        textPanel.add(user);
        textPanel.add(pass);
        user.setFont(new Font("Helvetica", Font.PLAIN, 16));
        pass.setFont(new Font("Helvetica", Font.PLAIN, 16));
        contentPane.add(textPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout());
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        buttonPanel.add(loginButton).setFont(new Font("Helvetica", Font.PLAIN, 16));
        buttonPanel.add(registerButton).setFont(new Font("Helvetica", Font.PLAIN, 16));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Register")) {
            try {
                Desktop.getDesktop().browse(new URL("https://westonreed.com/picross/register.php").toURI());
            } catch (URISyntaxException | IOException ex) {
                ex.printStackTrace();
            }
        }
        if (actionCommand.equals("Login")) {
            URL url = null;
            try {
                url = new URL("http://westonreed.com/picross/checkpass.php?username=" + user.getText() + "&password=" + md5(pass.getText()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                for (String line; (line = reader.readLine()) != null;) {
                    switch (line) {
                        case "0":
                            JOptionPane.showMessageDialog(this, "Password is correct!");
                            username = user.getText();
                            password = md5(pass.getText());
                            LOGIN = true;
                            this.dispose();
                            break;
                        case "1":
                            JOptionPane.showMessageDialog(this, "Password is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
                            pass.setText("");
                            break;
                        case "2":
                            JOptionPane.showMessageDialog(this, "User does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                            pass.setText("");
                            break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginBox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String md5(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(String.format("%02x", array[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }

    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean access(){
        return LOGIN;
    }
}