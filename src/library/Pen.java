package library;

public class Pen extends Products implements Discountable{


    public Pen(String name, int id, double price, boolean isOnOffer,double offerDiscount) {

        super(name,id,price,isOnOffer,offerDiscount);
    }


    @Override
    public double calculatedDiscountedPrice() {

        return 0;

    }

    @Override
    public String noPensMessage() {
        return "Ne pare rau!! Am ramas fara pixuri la oferta!!!!";
    }




}
