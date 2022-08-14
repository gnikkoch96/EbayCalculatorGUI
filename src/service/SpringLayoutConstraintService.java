package service;

import javax.swing.*;

public class SpringLayoutConstraintService {
    public static void addSpringLayoutConstraint(SpringLayout springLayout, String padDir, JComponent component, int padVal, JPanel panel){
        switch (padDir.toUpperCase()){
            case "WEST":
                springLayout.putConstraint(SpringLayout.WEST, component, padVal, SpringLayout.WEST, panel);
                break;
            case "NORTH":
                springLayout.putConstraint(SpringLayout.NORTH, component, padVal, SpringLayout.NORTH, panel);
                break;
            case "SOUTH":
                springLayout.putConstraint(SpringLayout.SOUTH, component, padVal, SpringLayout.SOUTH, panel);
                break;
            case "EAST":
                springLayout.putConstraint(SpringLayout.EAST, component, padVal, SpringLayout.EAST, panel);
                break;
        }
    }
}
