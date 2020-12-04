package Models;

public class LongTermDeposit extends Deposit {
    private String term;
    private String promotion;

    public LongTermDeposit() {
    }

    public LongTermDeposit(String depositId, String customerId, String createdDate, String startDate, String amount, String rate, String term, String promotion) {
        super(depositId, customerId, createdDate, startDate, amount, rate);
        this.term = term;
        this.promotion = promotion;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return
               depositId +
                ","+ customerId +
                "," + createdDate +
                "," + startDate +
                "," + amount +
                "," + rate +
                "," + term +
                "," + promotion
                ;
    }

    @Override
    public String showInfo() {
        return "LongTermDeposit{" +
                "term='" + term + '\'' +
                ", promotion='" + promotion + '\'' +
                ", depositId='" + depositId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", amount='" + amount + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
