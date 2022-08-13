package gui;

import contstants.CommonConstants;
import utils.LoadImageService;

import javax.swing.*;
import java.awt.*;

public class EbayCalculatorGUI extends JFrame {
    public EbayCalculatorGUI() throws Exception {
        super(CommonConstants.APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        addGUIItems();

        this.setVisible(true);
    }

    public void addGUIItems() throws Exception{
        addImageLayer();
        addItemPanel();
        addProfitPanel();
    }

    // Adds the Logo for the GUI
    public void addImageLayer() throws Exception{
        // I am starting to see how important it is to look at someone else's code and understanding. I would honestly recommend going to a
        // decently sized open source program where you can try to learn about the whole process or even just a portion of the process and see
        // how it is coded. You can learn from reading the code
        JLabel image = LoadImageService.loadImage(CommonConstants.LOGO_FILENAME);
        JPanel imageLayer = new JPanel();

        if(image == null){
            System.out.println("ERROR Image not loaded...Aborting Program 3...2..1.");
            throw new Exception();
        }

        imageLayer.add(image);

        this.getContentPane().add(imageLayer, BorderLayout.NORTH);

    }

    // Adds GUI Items for Item costs and sold
    public void addItemPanel(){
        JPanel purchaseItem = new JPanel();
        purchaseItem.setLayout(new GridLayout(2, 2));

        // Item Cost
        JPanel itemCost = new JPanel();
        JLabel lItemCost = new JLabel(CommonConstants.ITEM_COST_LABEL);
        JTextField tFItemCost = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        itemCost.add(lItemCost);
        itemCost.add(tFItemCost);

        // Item Shipping
        JPanel itemShippingCost = new JPanel();
        JLabel lItemShipping = new JLabel(CommonConstants.ITEM_SHIPPING_LABEL);
        JTextField tFItemShipping = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        itemShippingCost.add(lItemShipping);
        itemShippingCost.add(tFItemShipping);

        purchaseItem.add(itemCost);
        purchaseItem.add(itemShippingCost);
        this.getContentPane().add(purchaseItem, BorderLayout.CENTER);

        // Item Sold
        // Item Sold Shipping

    }

    // Adds GUI Items that displays the profit and profit percentage
    public void addProfitPanel(){

    }

}
