package mylittlemozart.csvparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidiCsvParser {
	public static void printMidi(ArrayList<MidiEventData> midiList) {
		if (midiList == null) {
			System.out.println("No midi loaded");
			return;
		}
		for (MidiEventData event : midiList) {
			System.out.println(event.toString());
		}
	}
	
	public static ArrayList<MidiEventData> parseCsv(String filePath) {
		Scanner fileInput = null;
		ArrayList<MidiEventData> midiList = new ArrayList<MidiEventData>();
		try {
			fileInput = new Scanner(new FileInputStream(filePath));

		} catch (FileNotFoundException exeption) {
			System.out.println("File was not found.");
			midiList = null;
			return midiList;
		}
		while (fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			String[] data = line.split(",");
			int startEndTick = Integer.parseInt(data[0].trim());
			int noteOnOff = (data[1].trim().equals("Note_on_c")) ? 1 : 0;
			int channel = Integer.parseInt(data[2].trim());
			int note = Integer.parseInt(data[3].trim());
			int velocity = Integer.parseInt(data[4].trim());
			int instrument = Integer.parseInt(data[5].trim());
			midiList.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
		}
		fileInput.close();
		return midiList;
	}
}
