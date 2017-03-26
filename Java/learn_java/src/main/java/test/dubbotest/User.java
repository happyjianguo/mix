package test.dubbotest;

import java.io.Serializable;

/**
 * Created by joshua on 17/3/26.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private Integer age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
