package testing;

import entitiy.JNumTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextField_ActionListener extends JFrame{
//    JTextField text = new JTextField("Press Return", 40);
    JNumTextField text = new JNumTextField(40);

    public JTextField_ActionListener() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Text=" + text.getText());

            }
        });

        getContentPane().add(text, "Center");
        pack();
    }

    public static void main(String[] args) {
        new JTextField_ActionListener().setVisible(true);
        System.out.println((Double.parseDouble("11.")));
    }
}
