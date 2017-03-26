package test.springaoporigin;

/**
 * Created by joshua on 17/3/26.
 */
public class Audience {

    // 表演之前
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    // 表演之前
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    // 表演之后
    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    // 表演失败之后
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }
}
