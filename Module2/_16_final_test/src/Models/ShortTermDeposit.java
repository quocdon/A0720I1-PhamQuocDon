package Models;

public class ShortTermDeposit extends Deposit {
    public ShortTermDeposit() {
    }

    public ShortTermDeposit(String depositId, String customerId, String createdDate, String startDate, String amount, String rate) {
        super(depositId, customerId, createdDate, startDate, amount, rate);
    }
}
