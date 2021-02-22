package serialization;

public class Employee
    implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public String address;

    public String name;

    public int number;

    public transient int SSN;

}
