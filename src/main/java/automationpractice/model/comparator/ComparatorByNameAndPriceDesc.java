package automationpractice.model.comparator;

import automationpractice.model.EntityDress;

import java.util.Comparator;

public class ComparatorByNameAndPriceDesc implements Comparator<EntityDress> {

    @Override
    public int compare(EntityDress o1, EntityDress o2) {
        int cmp = o1.getName().compareTo(o2.getName());
        if (cmp != 0)
            return cmp;

        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
