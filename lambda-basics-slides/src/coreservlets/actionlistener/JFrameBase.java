package coreservlets.actionlistener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

public abstract class JFrameBase extends JFrame {
    protected Container contentPane;
    protected JButton button1, button2, button3;

    public JFrameBase(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LafUtils.SetNimbusLaf();
        setSize(400, 300);
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.setBackground(Color.LIGHT_GRAY);
        button1 = new JButton("Blue");
        contentPane.add(button1);
        button2 = new JButton("Green");
        contentPane.add(button2);
        button3 = new JButton("Red");
        contentPane.add(button3);
    }

    protected void setBg(Color bgColor) {
        contentPane.setBackground(bgColor);
    }
}
