package library;

public class DiscountTooHighException extends RuntimeException {

    DiscountTooHighException(String s){
        super(s);
    }
}
