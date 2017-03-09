package test.threadlocal;

/**
 * Created by joshua on 17/3/9.
 */
public class Context {

    private String transactionId = null;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
