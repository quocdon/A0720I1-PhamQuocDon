package Models;

public class MonthsTermDeposit extends ShortTermDeposit {
    private String term;

    public MonthsTermDeposit(String term) {
        this.term = term;
    }

    public MonthsTermDeposit(String depositId, String customerId, String createdDate, String startDate, String amount, String rate, String term) {
        super(depositId, customerId, createdDate, startDate, amount, rate);
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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
                        "," + term
                ;
    }

    @Override
    public String showInfo() {
        return "MonthsTermDeposit{" +
                "term='" + term + '\'' +
                ", depositId='" + depositId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", amount='" + amount + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
