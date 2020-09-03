package redt.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyBooks implements Serializable {
    private List<Book> list;
    public MyBooks(){
        list = new ArrayList<>();
    }

    public List<Book> getList() {
        return list;
    }

    public void add(Book book){
        list.add(book);
    }

    public void remove(Book book){
        list.remove(book);
    }
}
