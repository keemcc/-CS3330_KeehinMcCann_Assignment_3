package mylittlemozart.midievent.concretefactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * Interface for creating a MidiEventFactory, provides methods createNoteOn and createNoteOff to be implemented
 */
public interface MidiEventFactory {
	/**
	 * Creates a MidiEvent for a note that is on
	 * @param tick tick the note lands on
	 * @param note note the note is
	 * @param velocity velocity of the note
	 * @param channel channel the note is played on
	 * @return Returns MidiEvent that was created
	 * @throws InvalidMidiDataException if the passed data is invalid
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	/**
	 * Creates a MidiEvent for a note that is off
	 * @param tick tick the note ends on
	 * @param note note the note is
	 * @param channel channel the note is played on
	 * @return Returns MidiEvent that was created
	 * @throws InvalidMidiDataException if the passed data is invalid
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
