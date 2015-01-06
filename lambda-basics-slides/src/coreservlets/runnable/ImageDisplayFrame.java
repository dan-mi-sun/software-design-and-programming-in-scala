package coreservlets.runnable;

import coreservlets.actionlistener.LafUtils;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// TODO: How to compare timing for single vs. multithreaded? Just make poolsize 1?
//       Make poolsize a final variable. BETTER: pass it in to parent class and have two versions.

public class ImageDisplayFrame extends JFrame {
    private final JPanel imagePanel;
    private final String imagePattern = "cafe-%s.jpg";
    private final int numImages = 22;

    public ImageDisplayFrame(int poolSize) throws Exception {
        super("Some Internet Cafes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LafUtils.SetNimbusLaf();
        imagePanel = new JPanel();
        imagePanel.setBackground(Color.LIGHT_GRAY);
        JScrollPane contentPane = new JScrollPane(imagePanel);
        setContentPane(contentPane);
        ExecutorService taskList = Executors.newFixedThreadPool(poolSize);
        long before = System.currentTimeMillis();
        for (int i = 1; i <= numImages; i++) {
            JLabel label = new JLabel();
            URL location = new URL(String.format(imagePattern, i));
            taskList.execute(() -> {
                ImageIcon icon = new ImageIcon(location);
                label.setIcon(icon);
            });
            imagePanel.add(label);
            System.out.println("Retrieved image " + i);
        }
        taskList.shutdown();
        taskList.awaitTermination(60, TimeUnit.SECONDS);
        long after = System.currentTimeMillis();
        System.out.println("Number of milliseconds for all images = " + (after - before));
        setSize(640, 475);
        setVisible(true);
    }
}
