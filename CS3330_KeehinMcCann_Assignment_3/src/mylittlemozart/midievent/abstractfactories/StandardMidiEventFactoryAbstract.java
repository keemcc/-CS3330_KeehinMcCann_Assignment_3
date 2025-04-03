package mylittlemozart.midievent.abstractfactories;

import mylittlemozart.midievent.concretefactories.MidiEventFactory;
import mylittlemozart.midievent.concretefactories.StandardMidiEventFactory;

/**
 * This class implements the abstract factory interface, creating a StandardMidiEventFactory()
 */
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Returns a new StandardMidiEventFactory
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}
