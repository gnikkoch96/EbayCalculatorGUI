package service;

/*
 * Calculates the net profit and profit margin
 */
public class CalculateProfitService {
    public static float calculateNetProfit(float itemSold, float itemShipping, float itemBought){
        double ebayFees = ((itemSold + itemShipping) - itemBought) * 0.129;
        float netProfit = 0;

        try{
            netProfit = (float) ((itemSold + itemShipping) - itemBought - ebayFees);
        }catch (ArithmeticException e){
            netProfit = 0;
        }

        return netProfit;
    }

    public static float calculateNetProfitMargin(float itemSold, float itemShipping, float itemBought){
        float netProfit = calculateNetProfit(itemSold, itemShipping, itemBought);
        return (netProfit)/(itemSold + itemShipping) * 100;

    }
}
