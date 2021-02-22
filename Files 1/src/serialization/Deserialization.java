package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

    public static void main(
        final String[] args) {

        Employee emp = null;
        try {
            FileInputStream fileIn = new FileInputStream("employee.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee Class Not Found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + emp.name);
        System.out.println("Address" + emp.address);
        System.out.println("SSN: " + emp.SSN);
        System.out.println("Number: " + emp.number);
    }

}
