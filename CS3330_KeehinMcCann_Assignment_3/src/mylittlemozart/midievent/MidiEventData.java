package mylittlemozart.midievent;

public class MidiEventData {
	private int startEndTick, velocity, note, channel, noteOnOff;
	private int instrument;
	
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	@Override
	public String toString() {
		return ("" + startEndTick+ " " + velocity + " " + note + " " + channel + " " + noteOnOff + " " + instrument);
	}
}
