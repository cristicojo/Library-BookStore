package library;

public class Notebook extends Products implements Discountable {


    public Notebook(String name, int id, double price, boolean isOnOffer, double offerDiscount) {

        super(name, id, price, isOnOffer, offerDiscount);
    }


    @Override
    public double CalculatedDiscountedPrice() {

        if (isOnOffer)

            return price - (price * (offerDiscount / 2000));
        else
            return price;

    }

    @Override
    public String CalculatedDiscountedPricee() {
        return null;
    }


}
