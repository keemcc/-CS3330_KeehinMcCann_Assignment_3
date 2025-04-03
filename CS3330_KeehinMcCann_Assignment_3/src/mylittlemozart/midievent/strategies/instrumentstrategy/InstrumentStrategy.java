package mylittlemozart.midievent.strategies.instrumentstrategy;

import javax.sound.midi.Track;

/**
 * This interface contains a method to apply different instruments given a track and a channel
 */
public interface InstrumentStrategy {
	/**
	 * Applies the instrument to the passed track and channel
	 * @param track track to apply to
	 * @param channel channel to apply to
	 */
	void applyInstrument(Track track, int channel);
}
