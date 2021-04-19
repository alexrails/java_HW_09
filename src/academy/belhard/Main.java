package academy.belhard;

import academy.belhard.exceptions.EmptySourceFileException;
import academy.belhard.exceptions.TextException;
import academy.belhard.utils.PersonIOUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Address address1 = new Address("Minsk", "Lenina", 7);
        Address address2 = new Address("Moscow", "Arbat", 72);
        Address address3 = new Address("Kiev", "Tarasa B.", 85);

        Person s1 = new Person("Jhon", "Korzun", address1);
	    Person s2 = new Person("Max", "Pop", address2);
	    Person s3 = new Person("Alex", "Korzun", address3);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());

        List<Person> persons = new ArrayList<>(Arrays.asList(s1, s2, s3));

        //Write to file
        try {
            PersonIOUtil.writePersons("data.txt", persons);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Read from file
        System.out.println("--------------------------------Read data:");
        try {
            System.out.println(PersonIOUtil.readFromFile("data.txt"));
        } catch (IOException | EmptySourceFileException | TextException e) {
            e.printStackTrace();
        }
    }
}
