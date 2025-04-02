package mylittlemozart.midievent.concretefactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

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
		MidiEvent event = new MidiEvent(message, tick + 80);
		return event;
	}
}
