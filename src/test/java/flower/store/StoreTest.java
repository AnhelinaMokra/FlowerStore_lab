package flower.store;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class StoreTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 10;
    private static final int MAX_PRICE = 1000;

    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testAdd() {
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        for (int i = 0; i < quantity; i++) {
            FlowerBucket flowerBucket = new FlowerBucket();
            int numberPacks = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
            for (int j = 0; j < numberPacks; j++) {
                int numberFlowers = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
                flowerBucket.add(new FlowerPack(new Rose(), numberFlowers));
            }
            store.addBucket(flowerBucket);
        }
        Assertions.assertEquals(quantity, store.getAllBuckets().size());
    }


    @Test
    public void testSearch() {
        Flower tulip = new Flower();
        tulip.setFlowerType(FlowerType.TULIP);

        Flower chamomile = new Flower();
        chamomile.setFlowerType(FlowerType.CHAMOMILE);

        FlowerPack tulipPack = new FlowerPack(tulip, 5);
        FlowerPack chamomilePack = new FlowerPack(chamomile, 15);

        FlowerBucket bucket1 = new FlowerBucket();
        bucket1.add(tulipPack);

        FlowerBucket bucket2 = new FlowerBucket();
        bucket2.add(chamomilePack);
        bucket2.add(chamomilePack);
        store.addBucket(bucket1);
        store.addBucket(bucket2);

        Assertions.assertEquals(30, store.search(FlowerType.CHAMOMILE));
        Assertions.assertEquals(5, store.search(FlowerType.TULIP));
    }

}