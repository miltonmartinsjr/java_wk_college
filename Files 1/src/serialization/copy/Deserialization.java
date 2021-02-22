package serialization.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserialization {

    public static void main(
        final String[] args) {

        ArrayList<Employee> le = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream("employee.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0) {
                le.add((Employee) in.readObject());
            }
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
        System.out.println("Number of employee " + le.size());
        for (int i = 0; i < le.size(); i++) {
            System.out.println(
                "Name: "
                    + le.get(i)
                        .getName());
            System.out.println(
                "Address"
                    + le.get(i)
                        .getAddress());
            System.out.println(
                "SSN: "
                    + le.get(i)
                        .getSSN());
            System.out.println(
                "Number: "
                    + le.get(i)
                        .getNumber());
        }

    }
}
