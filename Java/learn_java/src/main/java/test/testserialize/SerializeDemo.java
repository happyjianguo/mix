package test.testserialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by joshua on 17/4/17.
 */
public class SerializeDemo {

    public static void main(String[] args) {

        Employee e = new Employee();
        e.setName("Joshua");
        e.setAddress("Shanghai");
        e.setSSN(123);
        e.setNumber(101);

        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
