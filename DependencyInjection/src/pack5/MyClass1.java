package pack5;

import java.sql.Connection;

public class MyClass1 {

    private final Connection s;

    MyClass1(final IConnection s) {

        this.s = s.getConnection();
    }

    public String ConnId() {

        return "Connection Id:, " + this.s;
    }

}
