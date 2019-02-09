package library;

public class Pen extends Products implements Discountable{


    public Pen(String name, int id, double price, boolean isOnOffer,double offerDiscount) {

        super(name,id,price,isOnOffer,offerDiscount);
    }


    @Override
    public double CalculatedDiscountedPrice() {

        return 0;

    }

    @Override
    public String CalculatedDiscountedPricee() {
        return "Ne pare rau!! Am ramas fara pixuri la oferta!!!!";
    }




}
