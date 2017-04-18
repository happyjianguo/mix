package test.common;

/**
 * Created by joshua on 16/12/3.
 */
public class SampleBean {
    private String name;
    private int age;

    public SampleBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public SampleBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
