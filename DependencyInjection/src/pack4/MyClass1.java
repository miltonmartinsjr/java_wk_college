package pack4;

import java.sql.Connection;

public class MyClass1 {

    private Connection s;

    public String ConnId() {

        return "Connection Id:, " + this.s;
    }

    public void set(
        final Connection s) {

        this.s = s;

    }

}
