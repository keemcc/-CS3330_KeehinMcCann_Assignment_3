package mylittlemozart.midievent.concretefactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * This class implements the MidiEventFactory to create legato notes, this is done by adding 80 ticks to the node off event
 */
public class LegatoMidiEventFactory implements MidiEventFactory{

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent event = new MidiEvent(message, tick);
		return event;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		//Add 80 ticks to the note off to create a legato feel
		MidiEvent event = new MidiEvent(message, (tick + 80));
		return event;
	}
}
