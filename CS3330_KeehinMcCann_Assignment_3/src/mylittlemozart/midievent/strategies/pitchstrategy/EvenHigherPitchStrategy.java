package mylittlemozart.midievent.strategies.pitchstrategy;

/**
 * This class implements the PitchStrategy to make the pitch of the note 8 semitones higher
 */
public class EvenHigherPitchStrategy implements PitchStrategy {

	@Override
	public int modifyPitch(int note) {
		return (note + 8);
	}
}
