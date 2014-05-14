package kolesov93.RunnerPlayer;

/**
 */
public class Song {
    private String name;
    private int bpm;

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song(String name, int bpm) {
        this.name = name;
        this.bpm = bpm;
    }
}
