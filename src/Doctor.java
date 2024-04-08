
public class Doctor {
    //Attributes
    private String name;
    private int age;
    private int experience_years;

    //Constructors
    public Doctor(String name, int age, int experience_years) {
        this.name = name;
        this.age = age;
        this.experience_years = experience_years;
    }

    public Doctor() {
        this.name = "";
        this.age = 0;
        this.experience_years = 0;
    }

    //Getters/Setters

    public String getName() {
        return name;
    }

    ;

    public int getAge() {
        return age;
    }

    ;

    public int getExperience_years() {
        return experience_years;
    }

    ;

    public void setName(String name) {
        this.name = name;
    }

    ;

    public void setAge(int age) {
        this.age = age;
    }

    ;

    public void setExperience_years(int experience_years) {
        this.experience_years = experience_years;
    }

    ;

    @Override
    public String toString() {
        return "Doctor:\nname: " + this.name +
                "\nage: " + this.age +
                "\nYears of Practice: " + this.experience_years;
    }
}
