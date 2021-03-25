import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.Random;

public class PasswordGenerator implements ActionListener {
    
    private JLabel label1, label2;
    private JFrame frame;
    private JPanel panel;

    public PasswordGenerator() {
        frame = new JFrame();

        JButton button = new JButton("Generate");
        button.addActionListener(this);

        label1 = new JLabel("Password:");
        label2 = new JLabel("");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Generator");
        frame.pack();
        frame.setVisible(true);

        panel.add(button);
        panel.add(label1);
        panel.add(label2);

    }
    
    public static void main(String[] args) {
        new PasswordGenerator();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int len = rndm();
        String str = geekPassword(len);
        label1.setText("Password: " + str);
        label2.setText("Password has automatically been copied to your clipboard");

        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static String geekPassword(int len) {           
        //System.out.print("New password is: ");
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTIVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>()";
        String values = capitalChars + smallChars + numbers + symbols;
        Random randomMethod = new Random();
        char[] password = new char[len];
        for (int i = 0; i < len; i++) {
            password[i] = values.charAt(randomMethod.nextInt(values.length()));
        }
        //return password;
        String str = String.valueOf(password);
        return str;
}
    
    private int rndm() {
        Random r = new Random();
        int low = 15;
        int high = 20;
        int result = r.nextInt(high-low) + low;
        return result;
    }
}
