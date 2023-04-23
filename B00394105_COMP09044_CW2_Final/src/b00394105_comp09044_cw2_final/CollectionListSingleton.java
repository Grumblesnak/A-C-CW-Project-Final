package b00394105_comp09044_cw2_final;

public class CollectionListSingleton {
    private static CollectionListSingleton instance = null;
    private CollectionList collectionList;

    private CollectionListSingleton() {
        collectionList = new CollectionList();
    }

    public static synchronized CollectionListSingleton getInstance() {
        if (instance == null) {
            instance = new CollectionListSingleton();
        }
        return instance;
    }

    public CollectionList getCollectionList() {
        return collectionList;
    }
}
