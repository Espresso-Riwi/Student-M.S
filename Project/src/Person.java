public abstract class Person {

    private String name;
    private int age;
    private String id;
    private Validations v = new Validations();

    public Person(String name, int age, String id) {
        setName(name);
        setAge(age);
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (v.isValidName(name)){
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (v.isPositiveWithNumber(age)){
            this.age = age;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
