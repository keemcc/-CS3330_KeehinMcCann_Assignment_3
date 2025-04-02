package mylittlemozart.csvparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidiCsvParser {
	private ArrayList<MidiEventData> midiList;
	
	public MidiCsvParser(String filePath) {
		Scanner fileInput = null;
		midiList = new ArrayList<MidiEventData>();
		try {
			fileInput = new Scanner(new FileInputStream(filePath));
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
		} catch (FileNotFoundException exeption) {
			System.out.println("File was not found.");
			midiList = null;
		}
	}
	
	public void printMidi() {
		if (midiList == null) {
			System.out.println("No midi loaded");
			return;
		}
		for (MidiEventData event : midiList) {
			System.out.println(event.toString());
		}
	}
}
