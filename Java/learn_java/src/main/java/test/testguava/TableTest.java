package test.testguava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;

public class TableTest {

    public static void main(String[] args) {
        Table<String, String, String> employeeTable = HashBasedTable.create();

        employeeTable.put("IBM", "101", "Mahesh");
        employeeTable.put("IBM", "102", "Ramesh");
        employeeTable.put("IBM", "103", "Suresh");

        employeeTable.put("Microsoft", "111", "Sohan");
        employeeTable.put("Microsoft", "112", "Mohan");
        employeeTable.put("Microsoft", "113", "Rohan");

        Map<String, String> ibmEmployees = employeeTable.row("IBM");
        for (Map.Entry<String, String> entry : ibmEmployees.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
