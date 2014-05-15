package kolesov93.RunnerPlayer;

public interface SampleProcessor {

    void process(long[] sample);

    public void init(int freq, int channels);
    
}
