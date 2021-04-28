package academy.belhard.utils;

import academy.belhard.Address;
import academy.belhard.exceptions.EmptySourceFileException;
import academy.belhard.Person;
import academy.belhard.exceptions.TextException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonIOUtil {
    public static void writePersons(String fileName, List<Person> persons) throws IOException {

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Person person : persons) {
                writer.write(person.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Person> readFromFile(String fileName) throws IOException, EmptySourceFileException, TextException {

        List<Person> persons = new ArrayList<>();

        if (PersonIOUtil.isFileBlank(fileName)){
            throw new EmptySourceFileException("Empty file!");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String fileLine;

            while ((fileLine = reader.readLine()) != null) {
                Person person = PersonIOUtil.toPerson(fileLine);

                persons.add(person);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    private static Person toPerson(String fileLine) throws TextException {
        String[] dataArray = fileLine.split(";");

        if (dataArray.length != 3) {
            throw new TextException("Wrong read!");
        }
        String firstName = dataArray[0].substring(dataArray[0].indexOf(" ") + 1);
        String lastName = dataArray[1].substring(dataArray[1].indexOf(" ") + 1);
        String address = dataArray[2].substring(dataArray[2].indexOf("{") + 1, dataArray[2].indexOf("}"));

        return new Person(firstName, lastName, PersonIOUtil.toAddress(address));
    }

    private static Address toAddress(String address) throws TextException {
        String[] dataArray = address.split(",");

        if (dataArray.length != 3) {
            throw new TextException("Wrong read!");
        }

        String City = dataArray[0].substring(dataArray[0].indexOf(" ") + 1);
        String Street = dataArray[1].substring(dataArray[1].indexOf(" ") + 1);
        int homeNumber = Integer.parseInt(dataArray[2].substring(dataArray[2].indexOf(":") + 2));

        return new Address(City, Street, homeNumber);
    }

    private static Boolean isFileBlank(String fileName) {
        File file = new File(fileName);
        return file.length() == 0;
    }

}
