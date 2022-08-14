package testing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class JFormattedTextField_Test extends JFrame{
    JFormattedTextField text = new JFormattedTextField("Hello");

    public JFormattedTextField_Test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Released: " + e.getKeyChar());
            }
        });

        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Text=" + text.getText());
            }
        });

        getContentPane().add(text, "Center");
        pack();
    }

    public static void main(String[] args) throws IOException {
        new JFormattedTextField_Test().setVisible(true);
        String path = new File(".").getCanonicalPath() + "\\logo.png";
        System.out.println(path);

    }
}
