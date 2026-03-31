package mar28.Bank;

//CUSTOM EXCEPTION
public class BalanceError extends RuntimeException{
    public BalanceError(String message) {
        super(message);
    }
}
