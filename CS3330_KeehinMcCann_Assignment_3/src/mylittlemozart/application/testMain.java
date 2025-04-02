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
import mylittlemozart.midievent.strategies.pitchstrategy.HigherPitchStrategy;
import mylittlemozart.midievent.strategies.pitchstrategy.LowerPitchStrategy;
import mylittlemozart.midievent.strategies.pitchstrategy.PitchStrategy;

public class testMain {

    public static void main(String[] args) {
        ArrayList<MidiEventData> midiList = MidiCsvParser.parseCsv("./musicfiles/mystery_song.csv");
        //MidiCsvParser.printMidi(midiList);

        try {
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();
            //MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
            //MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();

            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            //instrumentStrategy.applyInstrument(track, 0);
            //instrumentStrategy.applyInstrument(track, 1);
            //instrumentStrategy.applyInstrument(track, 2);
            //instrumentStrategy.applyInstrument(track, 3);
            //instrumentStrategy.applyInstrument(track, 4);
            //instrumentStrategy = new TrumpetStrategy();
            //instrumentStrategy.applyInstrument(track, 1);

            //PitchStrategy pitchStrategy = new LowerPitchStrategy();

            for (MidiEventData event : midiList) {
                //int note = pitchStrategy.modifyPitch(event.getNote());
            	int note = event.getNote();
                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(), note, event.getVelocity(), event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), note, event.getChannel()));
                }
            }

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRunning()) {
                Thread.sleep(500);
            }
            Thread.sleep(500);
            sequencer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
