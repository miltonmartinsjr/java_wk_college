package serialization.copy;

public class Employee
    implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String address;

    private String name;

    private int number;

    private transient int SSN;

    public final String getAddress() {

        return this.address;
    }

    public final String getName() {

        return this.name;
    }

    public final int getNumber() {

        return this.number;
    }

    public final int getSSN() {

        return this.SSN;
    }

    public final void setAddress(
        final String address) {

        this.address = address;
    }

    public final void setName(
        final String name) {

        this.name = name;
    }

    public final void setNumber(
        final int number) {

        this.number = number;
    }

    public final void setSSN(
        final int sSN) {

        this.SSN = sSN;
    }

}
