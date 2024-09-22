import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.*;

public class PasswordGenerator{
    private static final String CHARACTERS="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*-+=<>?/\\(){}[]";
    private SecureRandom random=new SecureRandom();

    /**
     * Generates a random password of the given length
     * @param length
     * @return
     */
    public String generatePassword( int length ){
        StringBuilder password=new StringBuilder();
        for ( int i=0; i<length; i++ ){
            int index=random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }

    /**
     * Programs the GUI
     */
    public void ProgramGUI() {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
 
        JLabel label = new JLabel("Password Length: ");

        // The Dropdown Box along with the options
        Integer[] lengthOptions= { 8, 9,10,11,12,13,14,15,16};
        JComboBox<Integer> field = new JComboBox<>(lengthOptions);
        
        // The Generate Password Button
        JButton button = new JButton("Generate Password");
        JLabel password = new JLabel("Generated Password: ");
        JTextField passwordField = new JTextField(20);
        passwordField.setEditable(false);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        password.setFont(new Font("Arial", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(200, 50));
        button.setFont(new Font("Arial", Font.BOLD, 16));
        label.setFont(new Font("Arial", Font.BOLD, 16));
        

        //Grid Layout Code

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor =GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 10 ,5, 10);

        gbc.gridx = 0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);

        gbc.gridy = 1;
        frame.add(field, gbc);

        gbc.gridy = 2;
        frame.add(button, gbc);


        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10 ,5, 10);
        frame.add(password, gbc);

        gbc.gridy = 4;
        passwordField.setPreferredSize(new Dimension(300, 50));
        frame.add(passwordField, gbc);

        // The actual generate button code
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int length = (Integer) field.getSelectedItem();
                String generatedPassword = generatePassword(length);
                passwordField.setText(generatedPassword);
            }
        });

        frame.setVisible(true);
        
    }

    public static void main(String[] args){
       SwingUtilities.invokeLater(() -> {
           PasswordGenerator pg = new PasswordGenerator();
           pg.ProgramGUI();   
        });
        
    }
}