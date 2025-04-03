package mylittlemozart.midievent;

/**
 * This class contains data relating to MidiEvents. It is used to create MidiEvents to be used in a sequence.
 */
public class MidiEventData {
	//These members hold integer values corresponding to data needed to create MidiEvents
	private int startEndTick, velocity, note, channel, noteOnOff, instrument;
	
	/**
	 * This constructor creates a new MidiEventData with the passed fields
	 * @param startEndTick start or end tick of note
	 * @param velocity velocity of note
	 * @param note value of note
	 * @param channel channel
	 * @param instrument instrument value
	 * @param noteOnOff whether or not the note is on or off
	 */
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	/**
	 * Returns the note
	 * @return note
	 */
	public int getNote() {
		return note;
	}
	/**
	 * Returns the noteOnOff value
	 * @return noteOnOff
	 */
	public int getNoteOnOff() {
		return noteOnOff;
	}
	/**
	 * Returns the start or end tick of the note
	 * @return startEndTick
	 */
	public int getStartEndTick() {
		return startEndTick;
	}
	/**
	 * Returns the velocity of the note
	 * @return velocity
	 */
	public int getVelocity() {
		return velocity;
	}
	/**
	 * Returns the channel of the note
	 * @return channel
	 */
	public int getChannel() {
		return channel;
	}
	/**
	 * Returns the instrument of the note
	 * @return instrument
	 */
	public int instrument() {
		return instrument;
	}
}
