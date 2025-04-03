package mylittlemozart.midievent.abstractfactories;

import mylittlemozart.midievent.concretefactories.MidiEventFactory;

/**
 * This interface provides the method createFactory to instantiate a MidiEventFactory object.
 */
public interface MidiEventFactoryAbstract {
	/**
	 * Creates a factory
	 * @return factory object
	 */
	MidiEventFactory createFactory();
}
