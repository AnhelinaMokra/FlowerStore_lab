package flower.store;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Store {
    private final ArrayList<FlowerBucket> allBuckets = new ArrayList<>();

    public int search(FlowerType flowerType) {
        int quan = 0;
        for (FlowerBucket bucket : allBuckets) {
            for (FlowerPack pack : bucket.getAllFlowerPacks()) {
                if (flowerType == pack.getFlower().getFlowerType()) {
                    quan += pack.getQuantity();
                }
            }
        }
        return quan;
    }

    public void addBucket(FlowerBucket bucket) {
        allBuckets.add(bucket);
    }
}