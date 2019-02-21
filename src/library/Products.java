package library;

public class Products<T> {

    String title;
    int id;
    double price;
    boolean isOnOffer;
    double offerDiscount;


    public Products(String title, int id, double price, boolean isOnOffer, double offerDiscount) {

        this.title = title;
        this.id = id;
        this.price = price;
        this.isOnOffer = isOnOffer;
        this.offerDiscount = offerDiscount;

    }



    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOnOffer() {
        return isOnOffer;
    }

    public double getOfferDiscount() {
        return offerDiscount;
    }
}
