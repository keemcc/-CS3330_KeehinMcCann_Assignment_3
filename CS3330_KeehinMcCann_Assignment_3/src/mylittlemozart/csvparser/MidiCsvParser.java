package mylittlemozart.csvparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.ShortMessage;

import mylittlemozart.midievent.MidiEventData;

/**
 * This class contains the parseCsv to parse midi data from a csv
 */
public class MidiCsvParser {
	/**
	 * This method parses a csv given the passed filepath.
	 * It will take the values on each line of the csv and create a MidiEventData object for each line.
	 * It will add each MidiEventData object to an ArrayList and return that list.
	 * @param filePath the path of the csv file
	 * @return midiList, an ArrayList of all MidiEventData objects, or null if an error occurs.
	 */
	public static ArrayList<MidiEventData> parseCsv(String filePath) {
		//Initialize fileInput and midiList
		Scanner fileInput = null;
		ArrayList<MidiEventData> midiList = new ArrayList<MidiEventData>();
		//Try to open the file. If an error occurs, the file was not found. Print this and return null
		try {
			fileInput = new Scanner(new FileInputStream(filePath));
		} catch (FileNotFoundException exeption) {
			System.out.println("File was not found.");
			return null;
		}
		//Try to read all lines of the file and assign the values to MidiEventData fields
		//In the event of an exception (NumberFormatException, out of bounds, or other) print that the data was invalid, close the file, and return null.
		try {
			while (fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				String[] data = line.split(",");
				int startEndTick = Integer.parseInt(data[0].trim());
				int noteOnOff = (data[1].trim().equals("Note_on_c")) ? ShortMessage.NOTE_ON : ShortMessage.NOTE_OFF;
				int channel = Integer.parseInt(data[2].trim());
				int note = Integer.parseInt(data[3].trim());
				int velocity = Integer.parseInt(data[4].trim());
				int instrument = Integer.parseInt(data[5].trim());
				midiList.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
			}
		} catch (Exception e) {
			System.out.println("Data was invalid.");
			fileInput.close();
			return null;
		}
		fileInput.close();
		return midiList;
	}
}
