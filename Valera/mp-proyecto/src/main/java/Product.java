
public class Product {
    private int id;
    private String title;
    private double price;

    public Product(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;

    }

    //Getters
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public double getPrice() {

        return this.price;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}