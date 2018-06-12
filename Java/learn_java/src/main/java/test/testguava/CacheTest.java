package test.testguava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    public static void main(String[] args) {

        final CacheTest cacheTest = new CacheTest();

        LoadingCache<String, Employee> employeeLoadingCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Employee>() {
                    @Override
                    public Employee load(String empId) throws Exception {
                        return cacheTest.getFromDatabase(empId);
                    }
                });

        try {
            System.out.println(employeeLoadingCache.get("110"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private Employee getFromDatabase(String empId) {
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        Map<String, Employee> database = new HashMap();
        database.put("100", e1);
        database.put("103", e2);
        database.put("110", e3);
        System.out.println("Database hit for " + empId);
        return database.get(empId);
    }

    class Employee {
        String name;
        String dept;
        String empId;

        public Employee(String name, String dept, String empId) {
            this.name = name;
            this.dept = dept;
            this.empId = empId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", dept='" + dept + '\'' +
                    ", empId='" + empId + '\'' +
                    '}';
        }
    }
}
