package mylittlemozart.midievent.concretefactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * This class implements MidiEventFactory and creates staccato notes, this is done by subtracting 120 ticks from the end of the note.
 */
public class StaccatoMidiEventFactory implements MidiEventFactory{

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent event = new MidiEvent(message, tick);
		return event;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		//Subtract 120 ticks from the note off so that it is staccato.
		MidiEvent event = new MidiEvent(message, (tick - 120));
		return event;
	}
}
