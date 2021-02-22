package pack1;

import java.sql.Connection;

public class MyClass1 {

    private final Connection s;

    MyClass1(final Connection s) {

        this.s = s;
    }

    public String ConnId() {

        return "Connection Id:, " + this.s;
    }

}
