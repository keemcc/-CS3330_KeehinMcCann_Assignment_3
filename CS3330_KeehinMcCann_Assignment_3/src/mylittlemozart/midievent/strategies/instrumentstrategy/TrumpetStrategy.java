package mylittlemozart.midievent.strategies.instrumentstrategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * This class implements the instrument strategy to apply an trumpet sound to the passed track and channel
 */
public class TrumpetStrategy implements InstrumentStrategy{

	@Override
	public void applyInstrument(Track track, int channel) {
		//Try to apply the instrument. If an error occurs, print stack trace
		try {
			ShortMessage message = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
			MidiEvent event = new MidiEvent(message, 0);
			track.add(event);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}
