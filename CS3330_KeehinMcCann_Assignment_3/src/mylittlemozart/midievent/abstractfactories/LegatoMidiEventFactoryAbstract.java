package mylittlemozart.midievent.abstractfactories;

import mylittlemozart.midievent.concretefactories.LegatoMidiEventFactory;
import mylittlemozart.midievent.concretefactories.MidiEventFactory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
