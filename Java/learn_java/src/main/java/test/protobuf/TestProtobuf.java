package test.protobuf;

import com.googlecode.protobuf.format.JsonFormat;

/**
 * protobuf test
 *
 * @see https://gold.xitu.io/entry/56fba6208ac2470054438486
 */
public class TestProtobuf {

    public static void main(String[] args) {
        Demo.Person person = Demo.Person.newBuilder()
                .setName("fanteathy")
                .setAge(20)
                .build();
        System.out.println(person.toByteArray());
        JsonFormat jsonFormat = new JsonFormat();
        String person2json = jsonFormat.printToString(person);
        System.out.println(person2json);
    }
}
