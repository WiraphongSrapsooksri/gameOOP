import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ToggleArray extends JPanel {
    private static final int SIDE = 5;

    public ToggleArray() {
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button selected: " + e.getActionCommand());
            }
        };

        setLayout(new GridLayout(SIDE, SIDE));
        ButtonGroup btnGroup = new ButtonGroup();
        for (int i = 0; i < SIDE * SIDE; i++) {
            String text = String.format("[%d, %d]", i % SIDE, i / SIDE);
            JToggleButton btn = new JToggleButton(text);
            btn.addActionListener(listener);
            btnGroup.add(btn);
            add(btn);
        }
    }

    private static void createAndShowGui() {
        ToggleArray mainPanel = new ToggleArray();

        JFrame frame = new JFrame("ToggleArray");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}