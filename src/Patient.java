
public class Patient {
    public String name;
    public Integer age;
    public boolean has_medical_card;

    public Patient(String name, Integer age, boolean has_medical_card) {
        this.name = name;
        this.age = age;
        this.has_medical_card = has_medical_card;

    }

    public Patient() {
        this.name = "";
        this.age = 0;
        this.has_medical_card = false;
    }

    // Getters

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean getHas_medical_card() {
        return has_medical_card;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHas_medical_card(boolean has_medical_card) {
        this.has_medical_card = has_medical_card;
    }

    // ToString
    @Override
    public String toString() {
        return "Patient:\n\tName: " + name + "\n\tAge: " + age + "\n\tHas Medical Card: " + has_medical_card;
    }

}
