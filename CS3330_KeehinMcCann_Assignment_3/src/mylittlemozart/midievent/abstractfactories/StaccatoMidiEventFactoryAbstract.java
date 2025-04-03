package mylittlemozart.midievent.abstractfactories;

import mylittlemozart.midievent.concretefactories.MidiEventFactory;
import mylittlemozart.midievent.concretefactories.StaccatoMidiEventFactory;

/**
 * This class implements the abstract factory interface, creating a StaccatoMidiEventFactory()
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Returns a new StaccatoMidiEventFactory
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
