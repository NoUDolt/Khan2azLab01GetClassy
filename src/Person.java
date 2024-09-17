public class Person {
    private String id;
    private String first_name;
    private String last_name;
    private String title;
    private int yearOfBirth;

    public Person(String id, String first_name, String last_name, String title, int yearOfBirth) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String fullName() {
        return first_name + " " + last_name;
    }

    public String formalName(){
        return title + " " + fullName();
    }

    public String getAge() {
        int age = 0;
        age = java.time.Year.now().getValue() - yearOfBirth;
        return String.valueOf(age);
    }

    public String getAge(int year){
       int age = 0;
        if (year >= yearOfBirth){
           age = year - yearOfBirth;
           return String.valueOf(age);
       }
        else {
            return "Error, selected year is before the person's birth year; they were not born yet";
        }
    }


    public String toCSV() {
        return id + ", " +
                first_name + ", " +
                last_name + ", " +
                title + ", " +
                yearOfBirth;
    }

    public String toJSON(){
        return id + ":" +
                first_name + ":" +
                last_name + ":" +
                title + ":" +
                yearOfBirth;
    }

    public String toXML(){
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YOB>%d</YOB></Person>",
                id, first_name, last_name, title, yearOfBirth);
    }

    @Override
    public String toString() {
        return id + "     " +
                first_name + "     " +
                last_name + "     " +
                title + "     " +
                yearOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return this.id.equals(person.id);
    }
}
