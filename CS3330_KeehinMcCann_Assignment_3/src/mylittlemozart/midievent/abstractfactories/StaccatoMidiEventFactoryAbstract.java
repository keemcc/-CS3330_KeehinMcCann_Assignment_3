package mylittlemozart.midievent.abstractfactories;

import mylittlemozart.midievent.concretefactories.MidiEventFactory;
import mylittlemozart.midievent.concretefactories.StaccatoMidiEventFactory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
