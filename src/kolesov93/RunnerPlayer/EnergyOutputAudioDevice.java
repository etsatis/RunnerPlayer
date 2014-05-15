package kolesov93.RunnerPlayer;

import java.util.LinkedList;
import java.util.Queue;
import javazoom.jl.decoder.JavaLayerException;


public class EnergyOutputAudioDevice extends BaseOutputAudioDevice {
    private int averageLength = 1024; // number of samples over which the average is calculated
    private final Queue<Short> instantBuffer = new LinkedList<Short>();

    public EnergyOutputAudioDevice(SampleProcessor processor) {
        super(processor);
    }

    @Override
    protected void outputImpl(short[] samples, int offs, int len) throws JavaLayerException {
        for(int i=0; i<len; i++)
            instantBuffer.offer(samples[i]);

        while(instantBuffer.size()>averageLength*channels)
        {
            long energy = 0;
            for(int i=0; i<averageLength*channels; i++)
                energy += Math.pow(instantBuffer.poll(), 2);

            if(processor != null)
                processor.process(new long[] { energy });
        }
    }

    public int getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(int averageLength) {
        this.averageLength = averageLength;
    }
}
