package b00394105_comp09044_cw2_final;

// MusicListSingleton is used to ensure that only one insance of the MusicList is active in the program when active
public class MusicListSingleton {
    private static MusicListSingleton instance = null;
    private MusicList musicList;

    private MusicListSingleton() {
        musicList = new MusicList();
    }

    // This ensures that the single instance of MusicList is synchronised
    // Instance is used for the singleton, so if there is no active instance then one will be create from the existing singleton (MusicList)
    public static synchronized MusicListSingleton getInstance() {
        if (instance == null) {
            instance = new MusicListSingleton();
        }
        return instance;
    }

    // Simply returns the musicList when called
    public MusicList getMusicList() {
        return musicList;
    }
}
