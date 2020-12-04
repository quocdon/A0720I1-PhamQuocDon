package Models;

public class Deposit {
    protected String depositId;
    protected String customerId;
    protected String createdDate;
    protected String startDate;
    protected String amount;
    protected String rate;

    public Deposit() {
    }

    public Deposit(String depositId, String customerId, String createdDate, String startDate, String amount, String rate) {
        this.depositId = depositId;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.amount = amount;
        this.rate = rate;
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String showInfo(){
        return "Deposit{" +
                "depositId='" + depositId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", amount=" + amount +
                ", rate=" + rate +
                '}';
    }



    @Override
    public String toString() {
        return "Deposit{" +
                "depositId='" + depositId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", amount=" + amount +
                ", rate=" + rate +
                '}';
    }
}
