package vo;

import po.Custom.OrderCustom;

import java.util.List;

/**
 * Created by p on 2017/5/10.
 */
public class OrderVo {

    private List<OrderCustom> orderCustoms;
    private double money;

    public List<OrderCustom> getOrderCustoms() {
        return orderCustoms;
    }

    public void setOrderCustoms(List<OrderCustom> orderCustoms) {
        this.orderCustoms = orderCustoms;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
