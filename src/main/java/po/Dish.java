package po;

/**
 * Created by p on 2017/5/5.
 */
public class Dish {
    private int id;
    private int productorId;
    private String name;
    private String price;
    private String ingredients;
    private String photoUrl;
    private int sales;

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", productorId=" + productorId +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", sales=" + sales +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductorId() {
        return productorId;
    }

    public void setProductorId(int productorId) {
        this.productorId = productorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
