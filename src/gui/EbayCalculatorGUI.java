package gui;

import contstants.CommonConstants;
import utils.LoadImageService;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class EbayCalculatorGUI extends JFrame {
    public EbayCalculatorGUI() throws Exception {
        super(CommonConstants.APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        this.setLocationRelativeTo(null);
//        this.setResizable(false);

        addGUIItems();

        this.setVisible(true);
    }

    public void addGUIItems() throws Exception{
        System.out.println("Start adding GUI items");
        addImageLayer();
        addItemPanel();
        addProfitPanel();
        System.out.println("End adding GUI items");
    }

    // Adds the Logo for the GUI
    public void addImageLayer() throws Exception{
        System.out.println("Start Loading Logo.");

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

        System.out.println("End Loading Logo.");
    }

    // Adds GUI Items for Item costs and sold
    public void addItemPanel(){
        System.out.println("Start adding Item Panel.");

        // Purchase Panel
        JPanel purchaseItem = new JPanel();
        SpringLayout sprLayout = new SpringLayout();
        purchaseItem.setLayout(sprLayout);

        // Item Cost
        JLabel lItemCost = new JLabel(CommonConstants.ITEM_COST_LABEL);
        JTextField tFItemCost = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);

        purchaseItem.add(lItemCost);
        purchaseItem.add(tFItemCost);


        // Item Shipping
        JLabel lItemShipping = new JLabel(CommonConstants.ITEM_SHIPPING_LABEL);
        JTextField tFItemShipping = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);

        purchaseItem.add(lItemShipping);
        purchaseItem.add(tFItemShipping);

        // Padding Configuration
        sprLayout.putConstraint(SpringLayout.WEST, lItemCost, 75, SpringLayout.WEST, purchaseItem);
        sprLayout.putConstraint(SpringLayout.NORTH, lItemCost, 5, SpringLayout.NORTH, purchaseItem);
        sprLayout.putConstraint(SpringLayout.WEST, tFItemCost, 160, SpringLayout.WEST, purchaseItem);
        sprLayout.putConstraint(SpringLayout.NORTH, tFItemCost, 5, SpringLayout.NORTH, purchaseItem);

        sprLayout.putConstraint(SpringLayout.WEST, lItemShipping, 75, SpringLayout.WEST, purchaseItem);
        sprLayout.putConstraint(SpringLayout.NORTH, lItemShipping, 35, SpringLayout.NORTH, purchaseItem);
        sprLayout.putConstraint(SpringLayout.WEST, tFItemShipping, 160, SpringLayout.WEST, purchaseItem);
        sprLayout.putConstraint(SpringLayout.NORTH, tFItemShipping, 35, SpringLayout.NORTH, purchaseItem);
        this.getContentPane().add(purchaseItem, BorderLayout.CENTER);



        // Item Sold
        // Item Sold Shipping

        // Selling Panel
        JPanel sellPanel = new JPanel();

        System.out.println("End adding Item Panel.");
    }

    // Adds GUI Items that displays the profit and profit percentage
    public void addProfitPanel(){

    }

}
