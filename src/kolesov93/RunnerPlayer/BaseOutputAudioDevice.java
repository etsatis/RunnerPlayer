/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 2009 http://www.streamhead.com
 */

package kolesov93.RunnerPlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDeviceBase;

/**
 *
 * @author pbackx
 */
public abstract class BaseOutputAudioDevice extends AudioDeviceBase {
    protected int position = 0;
    protected int freq;
    protected int channels;
    protected int samplesPerMillisecond;
    protected boolean init = false;
    protected SampleProcessor processor;

    public BaseOutputAudioDevice(SampleProcessor processor) {
        this.processor = processor;
    }

    @Override
    protected void openImpl() throws JavaLayerException {
        super.openImpl();
    }

    @Override
    protected void writeImpl(short[] samples, int offs, int len) throws JavaLayerException {
        if(!init)
        {
            freq = getDecoder().getOutputFrequency();
            channels = getDecoder().getOutputChannels();
            samplesPerMillisecond = (freq * channels)/1000;
            if(processor != null)
                processor.init(freq, channels);
            init = true;
        }
        position += len/samplesPerMillisecond;

        outputImpl(samples, offs, len);
    }

    protected abstract void outputImpl(short[] samples, int offs, int len) throws JavaLayerException;


    public int getPosition() {
        return position;
    }

    public SampleProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(SampleProcessor processor) {
        this.processor = processor;
    }
}
