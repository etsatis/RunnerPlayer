package kolesov93.RunnerPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kolesov93
 */
public class BasicSongProvider implements SongProvider {
    private List<Song> songList = new ArrayList<Song>();

    public void addSong(Song song) {
        songList.add(song);
    }

    @Override
    public Song getSongForSpeed(int speed) {
        Song bestMatch = null;

        int bestBpm = 60 + (int) ((double) speed * 8);

        for (Song song : songList) {
            if (bestMatch == null || Math.abs(bestMatch.getBpm() - bestBpm) > Math.abs(song.getBpm() - bestBpm)) {
                bestMatch = song;
            }
        }

        return bestMatch;
    }
}
