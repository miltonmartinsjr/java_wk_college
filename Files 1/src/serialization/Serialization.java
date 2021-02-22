package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    public static void main(
        final String[] args) {

        Employee emp = new Employee();
        emp.name = "Mary Brown";
        emp.address = "123 rue des exemples";
        emp.SSN = 11122333;
        emp.number = 101;

        try {
            FileOutputStream fileout = new FileOutputStream("employee.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(emp);
            out.close();
            fileout.close();
            System.out.println("Serialized data is saved in employee.dat");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

}
