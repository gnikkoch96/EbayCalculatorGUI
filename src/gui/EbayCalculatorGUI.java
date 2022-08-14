package gui;

import contstants.CommonConstants;
import utils.LoadImageService;
import utils.SpringLayoutConstraintService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EbayCalculatorGUI extends JFrame implements ActionListener {
    public EbayCalculatorGUI() throws Exception {
        super(CommonConstants.APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        this.setLocationRelativeTo(null);
//        this.setResizable(false);

        addGUIItems();
    }

    public void addGUIItems() throws Exception{
        System.out.println("Start adding GUI items");
        addImageGuiItems();
        addItemGuiItems();
//        addProfitGuiItems();
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

        JTextField tFItemSold = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemSold.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));
        tFItemSold.addActionListener(this);

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

        JTextField tFItemCost = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFItemCost.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_FONT_SIZE));

        itemPanel.add(lItemCost);
        itemPanel.add(tFItemCost);


        // Item Sold Configuration (Item Cost and Item Bought Shipping)
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, lItemCost, CommonConstants.ITEMPANEL_LABEL_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, lItemCost, CommonConstants.ITEMPANEL_ROW4_NORTH_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_WEST, tFItemCost, CommonConstants.ITEMPANEL_TEXTFIELD_WEST_PAD, itemPanel);
        SpringLayoutConstraintService.addSpringLayoutConstraint(sprLayout, CommonConstants.SPRINGLAYOUT_NORTH, tFItemCost, CommonConstants.ITEMPANEL_ROW4_NORTH_PAD, itemPanel);

        // Display Net Profit
        JLabel lNetProfit = new JLabel(CommonConstants.NET_PROFIT_LABEL);
        JTextField tFNetProfit = new JTextField(10);
        tFNetProfit.setHorizontalAlignment(SwingConstants.CENTER);
        tFNetProfit.setFont(new Font("Dialog", Font.PLAIN, 28));
        tFNetProfit.setEditable(false);
        itemPanel.add(lNetProfit);
        itemPanel.add(tFNetProfit);

        // Display Profit Margins
        JLabel lNetProfitMargins = new JLabel(CommonConstants.NET_PROFIT_MARGIN_LABEL);
        JTextField tFNetProfitMargins = new JTextField(8);
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

    public void addProfitGuiItems(){
        System.out.println("Start adding Profit GUI Items");

        JPanel profitPanel = new JPanel();

        // Display Net Profit
        JLabel lNetProfit = new JLabel(CommonConstants.NET_PROFIT_LABEL);
        JTextField tFNetProfit = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFNetProfit.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_NETPROFT_FONT_SIZE));
        profitPanel.add(lNetProfit);
        profitPanel.add(tFNetProfit);

        // Display Profit Margins
        JLabel lNetProfitMargins = new JLabel(CommonConstants.NET_PROFIT_MARGIN_LABEL);
        JTextField tFNetProfitMargins = new JTextField(CommonConstants.INPUT_TEXTFIELD_CHARSIZE);
        tFNetProfitMargins.setFont(new Font("Dialog", Font.PLAIN, CommonConstants.ITEMPANEL_NETPROFT_MARGIN_FONT_SIZE));
        profitPanel.add(lNetProfitMargins);
        profitPanel.add(tFNetProfitMargins);

        this.getContentPane().add(profitPanel, BorderLayout.CENTER);
        System.out.println("End adding Profit GUI Items");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
