package jp2016.voting;

public class Person {
    static int counter = 0;
    private String firstName;
    private String lastName;
    private final int id;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }
    
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (!(obj instanceof Person))
//            return false;
//        
//        Person other = (Person) obj;
//        return this.id == other.id; 
//    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
