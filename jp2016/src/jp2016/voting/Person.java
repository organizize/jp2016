package jp2016.voting;

public class Person {
    static long counter = 0;
    private String firstName;
    private String lastName;
    private final long id;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = counter++;
    }

    public long getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Person))
            return false;
        
        Person other = (Person) obj;
        return this.id == other.id; 
    }
    
    @Override
    public int hashCode() {
        final int bitsInInt = 32;
        final int lower32bits = (int) id;
        final int upper32bits = (int) (id >> bitsInInt);
        return lower32bits ^ upper32bits;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
