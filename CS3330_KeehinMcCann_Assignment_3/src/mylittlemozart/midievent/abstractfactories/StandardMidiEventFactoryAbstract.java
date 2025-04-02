package mylittlemozart.midievent.abstractfactories;

import mylittlemozart.midievent.concretefactories.MidiEventFactory;
import mylittlemozart.midievent.concretefactories.StandardMidiEventFactory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}
