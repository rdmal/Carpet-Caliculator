import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CarpetCalculator implements Calculatable{
    private float pricePerSqFt = 0.00F;
    private float installCharge = 0.00F;
    private float percentDiscount = 0.00F;
    private ArrayList<Room> shoppingCart  = new ArrayList<Room>();
    private float totalCost = 0.00F;

    public CarpetCalculator(float pricePerSqFt) {
     this.pricePerSqFt = pricePerSqFt;
    }

    public CarpetCalculator(float pricePerSqFt, float installCharge) {
     this.pricePerSqFt = pricePerSqFt;
     this.installCharge = installCharge;
    }

    @Override
    public void addRoom(Room rm) {
        shoppingCart.add(rm);
        return;
    }

    @Override
    public String getTotalCost() {
        for (Room i: shoppingCart){
            totalCost += i.getArea()*pricePerSqFt;
        }

        if (installCharge != 0.00F)
         totalCost = totalCost + installCharge;
        if (percentDiscount != 0.00F)
         totalCost = totalCost - (totalCost*percentDiscount/100);

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(totalCost);
    }

    @Override
    public void addPercentDiscount(float percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

}
