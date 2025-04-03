package mylittlemozart.application;

import java.util.ArrayList;
import javax.sound.midi.*;

import mylittlemozart.csvparser.MidiCsvParser;
import mylittlemozart.midievent.MidiEventData;
import mylittlemozart.midievent.abstractfactories.LegatoMidiEventFactoryAbstract;
import mylittlemozart.midievent.abstractfactories.MidiEventFactoryAbstract;
import mylittlemozart.midievent.abstractfactories.StaccatoMidiEventFactoryAbstract;
import mylittlemozart.midievent.abstractfactories.StandardMidiEventFactoryAbstract;
import mylittlemozart.midievent.concretefactories.MidiEventFactory;
import mylittlemozart.midievent.strategies.instrumentstrategy.ElectricBassGuitarStrategy;
import mylittlemozart.midievent.strategies.instrumentstrategy.InstrumentStrategy;
import mylittlemozart.midievent.strategies.instrumentstrategy.TrumpetStrategy;
import mylittlemozart.midievent.strategies.pitchstrategy.EvenHigherPitchStrategy;
import mylittlemozart.midievent.strategies.pitchstrategy.HigherPitchStrategy;
import mylittlemozart.midievent.strategies.pitchstrategy.LowerPitchStrategy;
import mylittlemozart.midievent.strategies.pitchstrategy.PitchStrategy;

/**
 * This class contains the main method for running the csv parser and playing the song that is generated
 */
public class Main {
    public static void main(String[] args) {
    	//Create midiList from parsed csv
        ArrayList<MidiEventData> midiList = MidiCsvParser.parseCsv("./musicfiles/mystery_song.csv");
        //Some errors, like MidiDataExeptions may occur if the csv is not properly formatted, therefore the program is surrounded by a try catch block
        try {
        	//Create the sequence object with project defined settings
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();
            
            //Selects the type of notes to be created
            //Any selection can be made here. Uncomment the one that is being used. I like standard.
            
            //MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            //MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
            
            MidiEventFactory factory = factoryAbstract.createFactory();

            //Selects instruments to be used for the tracks channels
            //Commented out is a generic one to test the strategies, however, I liked the sound of the piano more than these.
            
            //InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            //instrumentStrategy.applyInstrument(track, 0);
            //instrumentStrategy = new TrumpetStrategy();
            //instrumentStrategy.applyInstrument(track, 1);

            //Selects the pitchStrategy, I thought the EvenHigherPitchStrategy sounded kind of cool
            
            //PitchStrategy pitchStrategy = new HigherPitchStrategy();
            //PitchStrategy pitchStrategy = new LowerPitchStrategy();
            PitchStrategy pitchStrategy = new EvenHigherPitchStrategy();

            //For each event in the midiList, create either an on note or off note with the factory
            for (MidiEventData event : midiList) {
                int note = pitchStrategy.modifyPitch(event.getNote());
                //Used if no PitchStrategy is being used
            	//int note = event.getNote();
                //If the note is on, create a note on with the factory and event data, else, it is off, create a not off with the factory and event data.
                //Add this note to the track
                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(), note, event.getVelocity(), event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), note, event.getChannel()));
                }
            }

            //Create the sequencer, open it, set the sequence to be the generated sequence. 
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            //While the sequencer is still running, stop the program from closing.
            while (sequencer.isRunning()) {
                Thread.sleep(500);
            }
            Thread.sleep(500);
            //Close the sequencer
            sequencer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
