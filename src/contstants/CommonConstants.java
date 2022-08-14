package contstants;

public class CommonConstants {
    // Name that appears on top of the header
    public static final String APP_NAME = "Nikko's Ebay Calculator";

    // Size of the Frame (Width, Height)
    public static final int[] FRAME_SIZE = {500, 600};

    // Filename of the logo (referenced for the image)
    public static final String LOGO_FILENAME = "logo.png";

    public static final int INPUT_TEXTFIELD_CHARSIZE = 18;

    // Labels
    public static final String ITEM_SHIPPING_LABEL = "Ship Charge: ";
    public static final String ITEM_SOLD_LABEL = "Item Sold: ";
    public static final String ITEM_COST_LABEL = "Item Cost: ";
    public static final String NET_PROFIT_LABEL = "Net Profit:";
    public static final String NET_PROFIT_MARGIN_LABEL = "Profit Margin: ";

    // Font Size Configs
    public static final int ITEMPANEL_FONT_SIZE = 18;
    public static final int ITEMPANEL_NETPROFT_MARGIN_FONT_SIZE = 15;
    public static final int ITEMPANEL_NETPROFT_FONT_SIZE = 28;

    // Used for padding in the SpringLayout constraints
    public static final int ITEMPANEL_TEXTFIELD_WEST_PAD = 185;
    public static final int ITEMPANEL_LABEL_WEST_PAD = 45;
    public static final int ITEMPANEL_ROW1_NORTH_PAD = 45;
    public static final int ITEMPANEL_ROW2_NORTH_PAD = ITEMPANEL_ROW1_NORTH_PAD + 35;
    public static final int ITEMPANEL_ROW3_NORTH_PAD = ITEMPANEL_ROW2_NORTH_PAD + 35;
    public static final int ITEMPANEL_ROW4_NORTH_PAD = ITEMPANEL_ROW3_NORTH_PAD + 35;
    public static final int ITEMPANEL_ROW5_NORTH_PAD = ITEMPANEL_ROW4_NORTH_PAD + 125;
    public static final int ITEMPANEL_ROW6_NORTH_PAD = ITEMPANEL_ROW5_NORTH_PAD + 35;
    public static final int ITEMPANEL_ROW7_NORTH_PAD = ITEMPANEL_ROW6_NORTH_PAD + 65;
    public static final int ITEMPANEL_NET_PROFIT_LABEL_WEST_PAD = 215;
    public static final int ITEMPANEL_NET_PROFIT_TF_WEST_PAD = 125;
    public static final int ITEMPANEL_NET_PROFIT_MARGIN_LABEL_WEST_PAD = ITEMPANEL_NET_PROFIT_TF_WEST_PAD + 15;
    public static final int ITEMPANEL_NET_PROFIT_MARGIN_TF_WEST_PAD = ITEMPANEL_NET_PROFIT_MARGIN_LABEL_WEST_PAD + 100;

    public static final String SPRINGLAYOUT_WEST = "WEST";
    public static final String SPRINGLAYOUT_NORTH = "NORTH";
    public static final String SPRINGLAYOUT_SOUTH = "SOUTH";
    public static final String SPRINGLAYOUT_EAST = "EAST";


}