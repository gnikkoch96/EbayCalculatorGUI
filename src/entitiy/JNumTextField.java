package entitiy;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * This is a custom class of the TextField that only listens to number, dot,
 * or backspace presses
 */
public class JNumTextField extends JTextField{
    public JNumTextField(int charCount){
        super(charCount);

        //N: I can see why we use adapters because sometimes we only need to
        // override one method as opposed to more
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String val = getText();
                int len = val.length();

                if((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') ||
                        e.getKeyChar() == '.' ||
                        e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    setEditable(true);
                }else{
                    setEditable(false);
                }
            }
        });
    }

}
