package mylittlemozart.midievent;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}
