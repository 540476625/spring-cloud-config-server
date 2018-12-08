package constanst;

public class Demo {
    private String name2;
    private Integer age2;

    public String getName() {
        return name2;
    }

    public void setName(String name) {
        this.name2 = name;
    }

    public Integer getAge() {
        return age2;
    }

    public void setAge(Integer age) {
        this.age2 = age;
    }

    public Demo(String name, Integer age) {
        this.name2 = name;
        this.age2 = age;
    }
}
