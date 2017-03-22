package test.springjdbc;

/**
 * Created by joshua on 17/3/22.
 */
public interface CustomerDao {

    public void insert(Customer customer);

    public Customer findByCustomerId(int custId);
}
