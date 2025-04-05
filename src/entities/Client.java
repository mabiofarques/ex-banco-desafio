package entities;

import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Client {

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String name;
    private LocalDate birthdate;
    private String occupation;

    public Client() {
    }

    public Client(String name, LocalDate birthdate, String occupation) {
        this.name = name;
        this.birthdate = birthdate;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Birthdate: " + birthdate.format(fmt) +
                ", Occupation: " + occupation + " - ";
    }
}
