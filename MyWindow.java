package projectsPractice;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {

    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("Arial", Font.BOLD, 35);

    MyWindow() {
        setTitle("My Clock");
        setSize(400, 400);
        setLocation(300, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ✅ Create main panel with light background
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(new Color(255, 230, 230)); // light background
        setContentPane(panel);

        createGUI(panel);
        startClock();

        setVisible(true);
    }

    private void createGUI(JPanel panel) {
        heading = new JLabel("My Clock");
        clockLabel = new JLabel();

        heading.setFont(font);
        clockLabel.setFont(font);

        // ✅ Dark red text color
        heading.setForeground(new Color(139, 0, 0));
        clockLabel.setForeground(new Color(139, 0, 0));

        heading.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

        heading.setOpaque(false);
        clockLabel.setOpaque(false);

        panel.add(heading);
        panel.add(clockLabel);
    }

    private void startClock() {
        // ✅ Use Swing Timer (thread-safe)
        Timer timer = new Timer(1000, e -> {
            String time = new SimpleDateFormat("hh:mm:ss a").format(new Date());
            clockLabel.setText(time);
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyWindow::new);
    }
}