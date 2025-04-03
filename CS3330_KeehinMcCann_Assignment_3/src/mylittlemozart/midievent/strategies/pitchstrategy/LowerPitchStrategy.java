package mylittlemozart.midievent.strategies.pitchstrategy;

/**
 * This class implements the PitchStrategy to make the pitch of the note 2 semitones lower
 */
public class LowerPitchStrategy implements PitchStrategy{

	@Override
	public int modifyPitch(int note) {
		return (note - 2);
	}
}