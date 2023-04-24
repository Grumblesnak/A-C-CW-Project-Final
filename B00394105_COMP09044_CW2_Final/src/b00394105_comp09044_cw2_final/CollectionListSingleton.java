package b00394105_comp09044_cw2_final;

// CollectionListSingleton is used to ensure that only one insance of the CollectionList is active in the program when active
public class CollectionListSingleton {
    private static CollectionListSingleton instance = null;
    private CollectionList collectionList;

    private CollectionListSingleton() {
        collectionList = new CollectionList();
    }

    // This ensures that the single instance of CollectionList is synchronised
    // Instance is used for the singleton, so if there is no active instance then one will be create from the existing singleton (CollectionList)
    public static synchronized CollectionListSingleton getInstance() {
        if (instance == null) {
            instance = new CollectionListSingleton();
        }
        return instance;
    }

    // Simply returns the collectionList when called
    public CollectionList getCollectionList() {
        return collectionList;
    }
}
