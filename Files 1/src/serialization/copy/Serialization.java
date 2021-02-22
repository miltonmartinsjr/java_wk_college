package serialization.copy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    public static void main(
        final String[] args) {

        Employee emp1 = new Employee();
        emp1.setName("Mary Brown");
        emp1.setAddress("123 rue des exemples");
        emp1.setSSN(11122333);
        emp1.setNumber(101);

        Employee emp2 = new Employee();
        emp2.setName("John Smith");
        emp2.setAddress("555 rue des exemples");
        emp2.setSSN(11122555);
        emp2.setNumber(129);

        try {
            FileOutputStream fileout = new FileOutputStream("employee.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(emp1);
            out.writeObject(emp2);
            out.close();
            fileout.close();
            System.out.println("Serialized data is saved in employee.dat");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

}
