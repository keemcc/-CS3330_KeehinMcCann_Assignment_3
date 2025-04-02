package mylittlemozart.application;

import mylittlemozart.csvparser.MidiCsvParser;

public class testMain {

	public static void main(String[] args) {
		MidiCsvParser parser = new MidiCsvParser("./musicfiles/mystery_song.csv");
		parser.printMidi();
	}

}
