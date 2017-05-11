package po.Custom;

import po.Dish;
import po.Order;
import po.Productor;
import po.User;
import serviceImpl.OrderServiceImpl;

/**
 * Created by p on 2017/5/10.
 */
public class OrderCustom extends Order {
    private Dish dish;
    private Productor productor;
    private User user;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
