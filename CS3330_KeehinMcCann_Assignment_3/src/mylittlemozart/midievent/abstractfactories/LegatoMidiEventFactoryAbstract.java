package mylittlemozart.midievent.abstractfactories;

import mylittlemozart.midievent.concretefactories.LegatoMidiEventFactory;
import mylittlemozart.midievent.concretefactories.MidiEventFactory;

/**
 * This class implements the abstract factory interface, creating a LegatoMidiEventFactory()
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	/**
	 * Returns a new LegatoMidiEventFactory
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
