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

        // ItemPanel Panel
        JPanel itemPanel = new JPanel();
        SpringLayout sprLayout = new SpringLayout();
        itemPanel.setLayout(sprLayout);

        // Item Sold
        JLabel lItemSold = new JLabel(CommonConstants.ITEM_SOLD_LABEL);
        lItemSold.setFont(new Font("Dialog", Font.BOLD, CommonConstants.ITEMPANEL_FONT_SIZE));

        JTextField tFItemSold = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemSold.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));

        itemPanel.add(lItemSold);
        itemPanel.add(tFItemSold);

        // Item Sold Shipping
        JLabel lItemSoldShipping = new JLabel(CommonConstants.ITEM_SHIPPING_LABEL);
        lItemSoldShipping.setFont(new Font("Dialog", Font.BOLD, CommonConstants.ITEMPANEL_FONT_SIZE));

        JTextField tFItemSoldShipping = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemSoldShipping.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));

        itemPanel.add(lItemSoldShipping);
        itemPanel.add(tFItemSoldShipping);

        // Item Purchasing Configuration (Item Sold and Item Sold Shipping)
        sprLayout.putConstraint(SpringLayout.WEST, lItemSold, CommonConstants.ITEMPANEL_LABEL_WEST_PAD, SpringLayout.WEST, itemPanel);
        sprLayout.putConstraint(SpringLayout.NORTH, lItemSold, CommonConstants.ITEMPANEL_ROW1_NORTH_PAD, SpringLayout.NORTH, itemPanel);
        sprLayout.putConstraint(SpringLayout.WEST, tFItemSold, CommonConstants.ITEMPANEL_TEXTFIELD_WEST_PAD, SpringLayout.WEST, itemPanel);
        sprLayout.putConstraint(SpringLayout.NORTH, tFItemSold, CommonConstants.ITEMPANEL_ROW1_NORTH_PAD, SpringLayout.NORTH, itemPanel);

        sprLayout.putConstraint(SpringLayout.WEST, lItemSoldShipping, CommonConstants.ITEMPANEL_LABEL_WEST_PAD, SpringLayout.WEST, itemPanel);
        sprLayout.putConstraint(SpringLayout.NORTH, lItemSoldShipping, CommonConstants.ITEMPANEL_ROW2_NORTH_PAD, SpringLayout.NORTH, itemPanel);
        sprLayout.putConstraint(SpringLayout.WEST, tFItemSoldShipping, CommonConstants.ITEMPANEL_TEXTFIELD_WEST_PAD, SpringLayout.WEST, itemPanel);
        sprLayout.putConstraint(SpringLayout.NORTH, tFItemSoldShipping, CommonConstants.ITEMPANEL_ROW2_NORTH_PAD, SpringLayout.NORTH, itemPanel);


        // Item Cost
        JLabel lItemCost = new JLabel(CommonConstants.ITEM_COST_LABEL);
        lItemCost.setFont(new Font("Dialog", Font.BOLD, CommonConstants.ITEMPANEL_FONT_SIZE));

        JTextField tFItemCost = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemCost.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));

        itemPanel.add(lItemCost);
        itemPanel.add(tFItemCost);


        // Item Purchasing Configuration (Item Cost and Item Bought Shipping)
        sprLayout.putConstraint(SpringLayout.WEST, lItemCost, CommonConstants.ITEMPANEL_LABEL_WEST_PAD, SpringLayout.WEST, itemPanel);
        sprLayout.putConstraint(SpringLayout.NORTH, lItemCost, CommonConstants.ITEMPANEL_ROW4_NORTH_PAD, SpringLayout.NORTH, itemPanel);
        sprLayout.putConstraint(SpringLayout.WEST, tFItemCost, CommonConstants.ITEMPANEL_TEXTFIELD_WEST_PAD, SpringLayout.WEST, itemPanel);
        sprLayout.putConstraint(SpringLayout.NORTH, tFItemCost, CommonConstants.ITEMPANEL_ROW4_NORTH_PAD, SpringLayout.NORTH, itemPanel);

        this.getContentPane().add(itemPanel, BorderLayout.CENTER);
        System.out.println("End adding Item Panel.");
    }

    // Adds GUI Items that displays the profit and profit percentage
    public void addProfitPanel(){

    }

}
