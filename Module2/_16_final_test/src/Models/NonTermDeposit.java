package Models;

public class NonTermDeposit extends ShortTermDeposit {
    public NonTermDeposit() {
    }

    public NonTermDeposit(String depositId, String customerId, String createdDate, String startDate, String amount, String rate) {
        super(depositId, customerId, createdDate, startDate, amount, rate);
    }

    @Override
    public String toString() {
        return
                depositId +
                        ","+ customerId +
                        "," + createdDate +
                        "," + startDate +
                        "," + amount +
                        "," + rate
                ;
    }

    @Override
    public String showInfo() {
        return "NonTermDeposit{" +
                "depositId='" + depositId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", amount='" + amount + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
