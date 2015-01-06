package coreservlets.actionlistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame2 extends JFrameBase {
    public ButtonFrame2() {
        super("Anonymous Inner Classes");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setBg(Color.BLUE);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setBg(Color.GREEN);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setBg(Color.RED);
            }
        });
        setVisible(true);
    }
}
