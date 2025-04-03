package mylittlemozart.midievent.strategies.pitchstrategy;

/**
 * This interface is used to modify the pitch of a note
 */
public interface PitchStrategy {
	/**
	 * This method takes a note and returns a modified version of the note
	 * @param note note value
	 * @return modified note value
	 */
	int modifyPitch(int note);
}
