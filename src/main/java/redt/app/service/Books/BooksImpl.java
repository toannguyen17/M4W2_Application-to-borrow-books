package redt.app.service.Books;

import redt.app.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksImpl implements BooksManager {
    private static List<Book> list;

    public BooksImpl(){
        list = new ArrayList<>();

        Book book1 = new Book("Harry potter", 1);
        Book book2 = new Book("One piece", 3);
        Book book3 = new Book("Conan", 6);

        list.add(book1);
        list.add(book2);
        list.add(book3);
    }

    @Override
    public List<Book> getList() {
        return list;
    }
}
