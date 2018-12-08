package constanst;

public class Demo {
    private String name1;
    private Integer age1;

    public String getName() {
        return name1;
    }

    public void setName(String name) {
        this.name1 = name;
    }

    public Integer getAge() {
        return age1;
    }

    public void setAge(Integer age) {
        this.age1 = age;
    }

    public Demo(String name, Integer age) {
        this.name1 = name;
        this.age1 = age;
    }
}
