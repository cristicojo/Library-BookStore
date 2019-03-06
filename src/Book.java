public class Book extends Products implements Discountable{


    Book(String title, int id, double price, boolean isOnOffer, double offerDiscount){

        super(title,id,price,isOnOffer,offerDiscount);
    }

    @Override
    public double calculatedDiscountedPrice() {

        if (isOnOffer())

            return price - (price * (offerDiscount / 100));
        else
            return price;

    }

    @Override
    public String noPensMessage() {
        return null;
    }


}
