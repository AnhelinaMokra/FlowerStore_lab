package flower.store;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class FlowerBucket {

    private final ArrayList<FlowerPack> allFlowerPacks = new ArrayList<>();

    public void add(FlowerPack pack) {
        allFlowerPacks.add(pack);
    }

    public double getPrice() {
        double res = 0;
        for (FlowerPack pack : allFlowerPacks) {
            res += pack.getPrice();
        }
        return res;
    }
}