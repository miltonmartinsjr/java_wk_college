package myCompositeList;

public class MyCompositeList<T> {
    private T data;

    private boolean IsEmpty;

    private MyCompositeList<T> tail;

    public MyCompositeList() {

        this.IsEmpty = true;
        this.data = null;
        this.tail = null;
    }

    public MyCompositeList(final T data) {

        this.IsEmpty = false;
        this.data = data;
        this.tail = null;
    }

    public MyCompositeList(final T[] data) {

        if (data == null) {
            this.IsEmpty = true;
            this.data = null;
            this.tail = null;
        } else {
            MyCompositeList<T> list = this;
            for (int i = 0; i < data.length; i++) {
                list.IsEmpty = false;
                list.data = data[i];
                list.tail = new MyCompositeList<>();
                list = list.tail;
            }
        }
    }
}

class MyEmptyList<T>
    extends MyList<T> {
    boolean IsEmpty = true;
}

class MyList<T> {
    boolean IsEmpty = false;
}
