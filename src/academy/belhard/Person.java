package academy.belhard;

import academy.belhard.exceptions.NullFieldException;

public class Person {
    private String firstName;
    private String lastName;
    private Address address;

    public Person(String firstName, String lastName, Address address) throws NullFieldException{
        if(firstName == null || lastName == null || address == null){
            throw new NullFieldException("Filds can't be Null!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new NullFieldException("Field can't be null!");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null){
            throw new NullFieldException("Field can't be null!");
        }
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        if(address == null){
            throw new NullFieldException("Field can't be null!");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName: " + firstName + ';' +
                " lastName: " + lastName + ';' +
                " address: " + address.toString() +
                '}' + "\n";
    }
}
