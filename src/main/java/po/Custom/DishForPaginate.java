package po.Custom;

import po.Dish;

/**
 * Created by p on 2017/6/11.
 */
public class DishForPaginate extends Dish {
    private int maxId;
    private int limit;

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
