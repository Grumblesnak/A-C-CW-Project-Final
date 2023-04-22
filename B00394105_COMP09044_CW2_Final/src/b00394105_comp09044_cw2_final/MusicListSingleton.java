package b00394105_comp09044_cw2_final;

public class MusicListSingleton {
    private static MusicListSingleton instance = null;
    private MusicList musicList;

    private MusicListSingleton() {
        musicList = new MusicList();
    }

    public static synchronized MusicListSingleton getInstance() {
        if (instance == null) {
            instance = new MusicListSingleton();
        }
        return instance;
    }

    public MusicList getMusicList() {
        return musicList;
    }
}
