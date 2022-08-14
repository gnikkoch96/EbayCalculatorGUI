package gui;

import contstants.CommonConstants;
import entitiy.JNumTextField;
import service.CalculateProfitService;
import service.LoadImageService;
import service.SpringLayoutConstraintService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class EbayCalculatorGUI extends JFrame implements KeyListener {

    JNumTextField tFItemSold, tFItemSoldShipping, tFItemCost, tFNetProfitMargins, tFNetProfit;

    public EbayCalculatorGUI() throws Exception {
        super(CommonConstants.APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        addGUIItems();
    }

    public void addGUIItems() throws Exception{
        System.out.println("Start adding GUI items");
        addImageGuiItems();
        addItemGuiItems();
        System.out.println("End adding GUI items");
    }

    // Adds the Logo for the GUI
    public void addImageGuiItems() throws Exception{
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
    public void addItemGuiItems(){
        System.out.println("Start adding Item Panel.");

        // ItemPanel Panel
        JPanel itemPanel = new JPanel();
//        itemPanel.setBackground(new Color(3,4,3));

        SpringLayout sprLayout = new SpringLayout();
        itemPanel.setLayout(sprLayout);

        // Item Sold
        JLabel lItemSold = new JLabel(CommonConstants.ITEM_SOLD_LABEL);
        lItemSold.setFont(new Font("Dialog", Font.BOLD, CommonConstants.ITEMPANEL_FONT_SIZE));

        tFItemSold = new JNumTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemSold.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));
        tFItemSold.addKeyListener(this);

        itemPanel.add(lItemSold);
        itemPanel.add(tFItemSold);

        // Item Sold Shipping
        JLabel lItemSoldShipping = new JLabel(CommonConstants.ITEM_SHIPPING_LABEL);
        lItemSoldShipping.setFont(new Font("Dialog", Font.BOLD, CommonConstants.ITEMPANEL_FONT_SIZE));

        tFItemSoldShipping = new JNumTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemSoldShipping.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));
        tFItemSoldShipping.addKeyListener(this);

        itemPanel.add(lItemSoldShipping);
        itemPanel.add(tFItemSoldShipping);

        // Item Purchasing Configuration (Item Sold and Item Sold Shipping)
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, lItemSold, CommonConstants.ITEMPANEL_LABEL_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, lItemSold, CommonConstants.ITEMPANEL_ROW1_NORTH_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, tFItemSold, CommonConstants.ITEMPANEL_TEXTFIELD_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, tFItemSold, CommonConstants.ITEMPANEL_ROW1_NORTH_PAD, itemPanel);

        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, lItemSoldShipping, CommonConstants.ITEMPANEL_LABEL_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, lItemSoldShipping, CommonConstants.ITEMPANEL_ROW2_NORTH_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, tFItemSoldShipping, CommonConstants.ITEMPANEL_TEXTFIELD_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, tFItemSoldShipping, CommonConstants.ITEMPANEL_ROW2_NORTH_PAD, itemPanel);

        // Item Cost
        JLabel lItemCost = new JLabel(CommonConstants.ITEM_COST_LABEL);
        lItemCost.setFont(new Font("Dialog", Font.BOLD, CommonConstants.ITEMPANEL_FONT_SIZE));

        tFItemCost = new JNumTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemCost.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));
        tFItemCost.addKeyListener(this);

        itemPanel.add(lItemCost);
        itemPanel.add(tFItemCost);


        // Item Sold Configuration (Item Cost and Item Bought Shipping)
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, lItemCost, CommonConstants.ITEMPANEL_LABEL_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, lItemCost, CommonConstants.ITEMPANEL_ROW4_NORTH_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, tFItemCost, CommonConstants.ITEMPANEL_TEXTFIELD_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, tFItemCost, CommonConstants.ITEMPANEL_ROW4_NORTH_PAD, itemPanel);

        // Display Net Profit
        JLabel lNetProfit = new JLabel(CommonConstants.NET_PROFIT_LABEL);
        lNetProfit.setFont(new Font("Dialog", Font.BOLD, CommonConstants.ITEMPANEL_FONT_SIZE));

        tFNetProfit = new JNumTextField(10);
        tFNetProfit.setHorizontalAlignment(SwingConstants.CENTER);
        tFNetProfit.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_NETPROFT_FONT_SIZE));
        tFNetProfit.setEditable(false);
        itemPanel.add(lNetProfit);
        itemPanel.add(tFNetProfit);

        // Display Profit Margins
        JLabel lNetProfitMargins = new JLabel(CommonConstants.NET_PROFIT_MARGIN_LABEL);

        tFNetProfitMargins = new JNumTextField(9);
        tFNetProfitMargins.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_NETPROFT_MARGIN_FONT_SIZE));
        tFNetProfitMargins.setEditable(false);
        itemPanel.add(lNetProfitMargins);
        itemPanel.add(tFNetProfitMargins);

        // Profit Configuration (Net Profit and Net Profit Margin)
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, lNetProfit, CommonConstants.ITEMPANEL_NET_PROFIT_LABEL_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, lNetProfit, CommonConstants.ITEMPANEL_ROW5_NORTH_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, tFNetProfit, CommonConstants.ITEMPANEL_NET_PROFIT_TF_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, tFNetProfit, CommonConstants.ITEMPANEL_ROW6_NORTH_PAD, itemPanel);

        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, lNetProfitMargins, CommonConstants.ITEMPANEL_NET_PROFIT_MARGIN_LABEL_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, lNetProfitMargins, CommonConstants.ITEMPANEL_ROW7_NORTH_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, tFNetProfitMargins, CommonConstants.ITEMPANEL_NET_PROFIT_MARGIN_TF_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, tFNetProfitMargins, CommonConstants.ITEMPANEL_ROW7_NORTH_PAD, itemPanel);


        this.getContentPane().add(itemPanel, BorderLayout.CENTER);
        System.out.println("End adding Item Panel.");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // retrieve the values from the fields
        float itemSoldVal, itemShippingVal, itemBoughtVal;

        try{
            itemSoldVal = Float.parseFloat(tFItemSold.getText());
        }catch(NumberFormatException nfe){
            itemSoldVal = 0;
        }

        try{
            itemShippingVal = Float.parseFloat(tFItemSoldShipping.getText());
        }catch(NumberFormatException nfe){
            itemShippingVal = 0;
        }

        try{
            itemBoughtVal = Float.parseFloat(tFItemCost.getText());
        }catch(NumberFormatException nfe){
            itemBoughtVal = 0;
        }

        // calculate the net profit
        float netProfit = CalculateProfitService.calculateNetProfit(itemSoldVal, itemShippingVal, itemBoughtVal);
        float netProfitMargin = CalculateProfitService.calculateNetProfitMargin(itemSoldVal, itemShippingVal, itemBoughtVal);

        // update the net profit gui items
        DecimalFormat df = new DecimalFormat("#.##");

        tFNetProfit.setText("$" + df.format(netProfit));
        tFNetProfitMargins.setText(df.format(netProfitMargin) + "%");

        // update the colors of the text
        if(netProfit < 0){
            tFNetProfit.setForeground(Color.RED);
        }else{
            tFNetProfit.setForeground(new Color(10, 110, 50));
        }

        if(netProfitMargin < 0){
            tFNetProfitMargins.setForeground(Color.RED);
        }else{
            tFNetProfitMargins.setForeground(new Color(10, 110, 50));
        }
    }
}
