package test.testserialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by joshua on 17/4/17.
 */
public class DeserializeDemo {

    public static void main(String[] args) {

        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.getName());
        System.out.println("Address: " + e.getAddress());
        System.out.println("SSN: " + e.getSSN());
        System.out.println("Number: " + e.getNumber());
    }
}
