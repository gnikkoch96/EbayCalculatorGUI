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
            //N: We override this method cause we have time to prevent the character from entering the textfield (keyType or keyReleased)
            @Override
            public void keyPressed(KeyEvent e) {
                boolean pressedDot = false;

                String val = getText();

                if(val.indexOf('.') >= 0){
                    pressedDot = true;
                }

                if((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') ||
                        e.getKeyChar() == '.' ||
                        e.getKeyCode() == KeyEvent.VK_BACK_SPACE){

                    if(e.getKeyChar() == '.' && pressedDot){
                        setEditable(false);
                    }else{
                        setEditable(true);
                    }

                }else{
                    setEditable(false);
                }
            }
        });
    }

}
