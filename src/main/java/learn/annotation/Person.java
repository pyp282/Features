package learn.annotation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by pei on 2017/3/15.
 */
@XmlRootElement
public class Person {
    String name;
    int age;
    String address;

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement(name = "Age")
    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "Address")
    public void setAddress(String address) {
        this.address = address;
    }
}
