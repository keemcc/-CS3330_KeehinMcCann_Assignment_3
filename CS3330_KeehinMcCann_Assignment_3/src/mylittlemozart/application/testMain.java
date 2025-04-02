package mylittlemozart.application;

import java.util.ArrayList;

import mylittlemozart.csvparser.MidiCsvParser;
import mylittlemozart.midievent.MidiEventData;

public class testMain {

	public static void main(String[] args) {
		ArrayList<MidiEventData> midiList = MidiCsvParser.parseCsv("./musicfiles/mystery_song.csv");
		MidiCsvParser.printMidi(midiList);
	}

}
