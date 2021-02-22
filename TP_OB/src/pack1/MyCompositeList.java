package pack1;

public class MyCompositeList<T> {

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

    class MyEmptyList<T>
        extends MyList<T> {
        boolean isEmpty = true;
    }

    class MyList<T> {
        boolean isEmpty = false;
    }

    class MyList(T v)

    private T data;

    private boolean isEmpty;// premier element

    private MyCompositeList<T> tail;

    {

        } // dernier element

}
