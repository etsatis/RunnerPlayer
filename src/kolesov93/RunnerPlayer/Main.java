package kolesov93.RunnerPlayer;

import java.io.FileInputStream;
import java.util.logging.Logger;
import javazoom.jl.player.Player;


public class Main {
    static Logger log = Logger.getLogger("BeatIt");

    public static void main(String[] args) throws Exception {
        BPM2SampleProcessor processor = new BPM2SampleProcessor();
        processor.setSampleSize(2048);
        EnergyOutputAudioDevice output = new EnergyOutputAudioDevice(processor);
        output.setAverageLength(1024);
        Player player = new Player(new FileInputStream(args[0]), output);
        player.play();
        System.out.println("File: " + args[0]);
        System.out.println("BPM: " + processor.getBPM());
    }
}
