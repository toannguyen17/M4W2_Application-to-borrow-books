package redt.app.model;

public class Book {
    private int id;
    private String name;
    private int number;
    public Book(){
    }

    public Book(String name, int number) {
        this.name = name;
        this.number = number;

        id = (int)(Math.random() * 89999 + 10000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void minus(){
        number--;
    }

    public void plus(){
        number++;
    }
}
