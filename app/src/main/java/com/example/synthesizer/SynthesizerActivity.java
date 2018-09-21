package com.example.synthesizer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaDrm;
import android.media.SoundPool;
import android.speech.tts.SynthesisCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener{

    private SoundPool soundPool;
    private Button buttonScale;
    private Button buttonChallenge1;
    private Button buttonChallenge2;
    private Button buttonChallenge5;
    private Button buttonChallenge9;
    private Button buttonChallenge10;
    private Button buttonDos;
    private NumberPicker numberPicker;
    private NumberPicker notePicker;
    private NumberPicker linePicker;
    private int currentCustomNum;
    private int currentCustomNote;
    private int currentLine;
    private Map<Integer, Integer> noteMap;

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;

    private Button buttonA2;
    private Button buttonBb2;
    private Button buttonB2;
    private Button buttonC2;
    private Button buttonCs2;
    private Button buttonD2;
    private Button buttonDs2;
    private Button buttonE2;
    private Button buttonF2;
    private Button buttonFs2;
    private Button buttonG2;
    private Button buttonGs2;

    //gives integer values to each note
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;

    private int noteA2;
    private int noteBb2;
    private int noteB2;
    private int noteC2;
    private int noteCs2;
    private int noteD2;
    private int noteDs2;
    private int noteE2;
    private int noteF2;
    private int noteFs2;
    private int noteG2;
    private int noteGs2;

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0F;
    public static final int WHOLE_NOTE = 1000; //in milliseconds
    public static final int HALF_NOTE = WHOLE_NOTE/2; //in milliseconds
    public static final int NOTE = 300;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
        setUpNumberPicker();
        setUpNotePicker();
        setUpLinePicker();

    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        //in a map you store a key:value pair
        //key is the buttonId, the value is the noteId
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_a2, noteA2);
        noteMap.put(R.id.button_synth_b2, noteB2);
        noteMap.put(R.id.button_synth_bb2, noteBb2);
        noteMap.put(R.id.button_synth_c2, noteC2);
        noteMap.put(R.id.button_synth_cs2, noteCs2);
        noteMap.put(R.id.button_synth_d2, noteD2);
        noteMap.put(R.id.button_synth_ds2, noteDs2);
        noteMap.put(R.id.button_synth_e2, noteE2);
        noteMap.put(R.id.button_synth_f2, noteF2);
        noteMap.put(R.id.button_synth_fs2, noteFs2);
        noteMap.put(R.id.button_synth_g2, noteG2);
        noteMap.put(R.id.button_synth_gs2, noteGs2);


        //repeat for all your notes you want individual buttons


    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);

        noteA2 = soundPool.load(this, R.raw.scalehigha, 1);
        noteBb2 = soundPool.load(this, R.raw.scalehighbb, 1);
        noteB2 = soundPool.load(this, R.raw.scalehighb, 1);
        noteC2 = soundPool.load(this, R.raw.scalehighc, 1);
        noteCs2 = soundPool.load(this, R.raw.scalehighcs, 1);
        noteD2 = soundPool.load(this, R.raw.scalehighd, 1);
        noteDs2 = soundPool.load(this, R.raw.scalehighds, 1);
        noteE2 = soundPool.load(this, R.raw.scalehighe, 1);
        noteF2 = soundPool.load(this, R.raw.scalehighf, 1);
        noteFs2 = soundPool.load(this, R.raw.scalehighfs, 1);
        noteG2 = soundPool.load(this, R.raw.scalehighg, 1);
        noteGs2 = soundPool.load(this, R.raw.scalehighgs, 1);
    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);

        buttonA2.setOnClickListener(noteListener);
        buttonBb2.setOnClickListener(noteListener);
        buttonB2.setOnClickListener(noteListener);
        buttonC2.setOnClickListener(noteListener);
        buttonCs2.setOnClickListener(noteListener);
        buttonD2.setOnClickListener(noteListener);
        buttonDs2.setOnClickListener(noteListener);
        buttonE2.setOnClickListener(noteListener);
        buttonF2.setOnClickListener(noteListener);
        buttonFs2.setOnClickListener(noteListener);
        buttonG2.setOnClickListener(noteListener);
        buttonGs2.setOnClickListener(noteListener);
        //challenge buttons still use the Activity's implementations
        buttonScale.setOnClickListener(this);
        buttonChallenge1.setOnClickListener(this);
        buttonChallenge2.setOnClickListener(this);
        buttonChallenge5.setOnClickListener(this);
        buttonChallenge9.setOnClickListener(this);
        buttonChallenge10.setOnClickListener(this);
        buttonDos.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);

        buttonA2 = findViewById(R.id.button_synth_a2);
        buttonBb2 = findViewById(R.id.button_synth_bb2);
        buttonB2 = findViewById(R.id.button_synth_b2);
        buttonC2 = findViewById(R.id.button_synth_c2);
        buttonCs2 = findViewById(R.id.button_synth_cs2);
        buttonD2 = findViewById(R.id.button_synth_d2);
        buttonDs2 = findViewById(R.id.button_synth_ds2);
        buttonE2 = findViewById(R.id.button_synth_e2);
        buttonF2 = findViewById(R.id.button_synth_f2);
        buttonFs2 = findViewById(R.id.button_synth_fs2);
        buttonG2 = findViewById(R.id.button_synth_g2);
        buttonGs2   = findViewById(R.id.button_synth_gs2);

        buttonScale = findViewById(R.id.button_main_scale);
        buttonChallenge1 = findViewById(R.id.button_main_challenge1);
        buttonChallenge2 = findViewById(R.id.button_main_challenge2);
        buttonChallenge5 = findViewById(R.id.button_main_challenge5);
        buttonChallenge9 = findViewById(R.id.button_main_challenge9);
        buttonChallenge10 = findViewById(R.id.button_main_challenge10);
        buttonDos = findViewById(R.id.button_main_song);
        numberPicker = findViewById(R.id.numberpicker_synth_number);
        notePicker = findViewById(R.id.numberpicker_synth_note);
        linePicker = findViewById(R.id.numberpicker_synth_line);



    }

    private void setUpNumberPicker() {
        if(numberPicker!= null) {
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(5);
            numberPicker.setWrapSelectorWheel(true);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    //String text = "Changed from " + oldVal + " to " + newVal;
                    //Toast.makeText(SynthesizerActivity.this, text, Toast.LENGTH_SHORT).show();
                    currentCustomNum = newVal;
                   String test = "Current custom number is now: " + numberPicker.getValue();
                    Toast.makeText(SynthesizerActivity.this, test, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void setUpNotePicker() {
        if (notePicker != null) {
            final String[] values = {"A", "B", "Bb", "C", "Cs", "D", "Ds", "E", "F", "Fs", "G","Gs", "A2"};
            notePicker.setMinValue(0);
            notePicker.setMaxValue(values.length -1);
            notePicker.setDisplayedValues(values);
            notePicker.setWrapSelectorWheel(true);
            notePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String text = "Changed from " + values[oldVal] +" to " + values[newVal];
                    Toast.makeText(SynthesizerActivity.this, text, Toast.LENGTH_SHORT).show();
                    currentCustomNote = newVal;
                }
            });

        }
    }

    private void setUpLinePicker() {
        if(linePicker!= null) {
            linePicker.setMinValue(0);
            linePicker.setMaxValue(5);
            linePicker.setWrapSelectorWheel(true);
            linePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    //String text = "Changed from " + oldVal + " to " + newVal;
                    //Toast.makeText(SynthesizerActivity.this, text, Toast.LENGTH_SHORT).show();
                    currentLine = newVal;
                    String test = "Current custom number is now: " + linePicker.getValue();
                    Toast.makeText(SynthesizerActivity.this, test, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public void onClick(View v) {
        //one method to handle the clicks of all the buttons
        //don't forget to tell the buttons who is doing the listening
        switch(v.getId()) {
            //these are all the other buttons besides the keys
            case R.id.button_main_scale:
                playScale();
                break;
            case R.id.button_main_challenge1:
                playCh1();
                break;
            case R.id.button_main_challenge2:
                playCh2();
                break;
            case R.id.button_main_challenge5:
                playCh5();
                break;
            case R.id.button_main_challenge9:
                playCh9();
                break;
            case R.id.button_main_challenge10:
                playCh10();
                break;
            case R.id.button_main_song:
                playDontStop();
                break;

        }
    }

    private void playDontStop() {
        Song DontStop = new Song();
        DontStop.add(new Note(noteA2, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteG, NOTE));
        DontStop.add(new Note(noteG, HALF_NOTE));
        DontStop.add(new Note(noteA2, WHOLE_NOTE)); //"just a small town girl
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteF, HALF_NOTE));
        DontStop.add(new Note(noteC2, NOTE));
        DontStop.add(new Note(noteC2, HALF_NOTE));
        DontStop.add(new Note(noteA2, HALF_NOTE));
        DontStop.add(new Note(noteG, WHOLE_NOTE));//"living in a lonely world
        DontStop.add(new Note(noteD, NOTE));
        DontStop.add(new Note(noteA2, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteG, 250));
        DontStop.add(new Note(noteG, HALF_NOTE));
        DontStop.add(new Note(noteA2, HALF_NOTE));//"she took the midnight train
        DontStop.add(new Note(noteG, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteG, WHOLE_NOTE));
        DontStop.add(new Note(noteA2, WHOLE_NOTE));
        DontStop.add(new Note(noteF, 2 * WHOLE_NOTE));//"going anywhere
        DontStop.add(new Note(noteA2, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteG, NOTE));
        DontStop.add(new Note(noteG, HALF_NOTE));
        DontStop.add(new Note(noteA2, WHOLE_NOTE)); //"just a city boy
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteF, HALF_NOTE));
        DontStop.add(new Note(noteC2, NOTE));
        DontStop.add(new Note(noteC2, HALF_NOTE));
        DontStop.add(new Note(noteA2, HALF_NOTE));
        DontStop.add(new Note(noteG, WHOLE_NOTE));//"born and raised in South Detroit
        DontStop.add(new Note(noteD, NOTE));
        DontStop.add(new Note(noteA2, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteG, 250));
        DontStop.add(new Note(noteG, HALF_NOTE));
        DontStop.add(new Note(noteA2, HALF_NOTE));//"he took the midnight train
        DontStop.add(new Note(noteG, NOTE));
        DontStop.add(new Note(noteF, NOTE));
        DontStop.add(new Note(noteG, WHOLE_NOTE));
        DontStop.add(new Note(noteA2, WHOLE_NOTE));
        DontStop.add(new Note(noteF, 2 *WHOLE_NOTE));//"going anywhere
        playSong(DontStop);
    }

    private void playCh10() {
        Song twink = new Song();
        addTwinkleLine1(twink);
        for (int i = 0; i <= linePicker.getValue() - 1; i ++) {
            addTwinkleLine2(twink);
        }
        playSong(twink);
    }

    private void playCh9() {
        Song twinklef = new Song();
        addTwinkleLine1(twinklef);
        addTwinkleLine2(twinklef);
        addTwinkleLine2(twinklef);
        addTwinkleLine1(twinklef);
        playSong(twinklef);
    }

    private void playCh5() {
        Song twinkle = new Song();
        addTwinkleLine1(twinkle);
        playSong(twinkle);

    }

    private void addTwinkleLine1(Song twinkle) {
        twinkle.add(new Note(noteA, HALF_NOTE));
        twinkle.add(new Note(noteA, HALF_NOTE));
        twinkle.add(new Note(noteE2, HALF_NOTE));
        twinkle.add(new Note(noteE2, HALF_NOTE));
        twinkle.add(new Note(noteFs2, HALF_NOTE));
        twinkle.add(new Note(noteFs2, HALF_NOTE));
        twinkle.add(new Note(noteE2, WHOLE_NOTE));
        twinkle.add(new Note(noteD, HALF_NOTE));
        twinkle.add(new Note(noteD, HALF_NOTE));
        twinkle.add(new Note(noteCs, HALF_NOTE));
        twinkle.add(new Note(noteCs, HALF_NOTE));
        twinkle.add(new Note(noteB, HALF_NOTE));
        twinkle.add(new Note(noteB, HALF_NOTE));
        twinkle.add(new Note(noteA, WHOLE_NOTE));
    }

    private void addTwinkleLine2(Song twinklef) {
        twinklef.add(new Note(noteE2, HALF_NOTE));
        twinklef.add(new Note(noteE2, HALF_NOTE));
        twinklef.add(new Note(noteD, HALF_NOTE));
        twinklef.add(new Note(noteD, HALF_NOTE));
        twinklef.add(new Note(noteCs, HALF_NOTE));
        twinklef.add(new Note(noteCs, HALF_NOTE));
        twinklef.add(new Note(noteB, WHOLE_NOTE));
    }

    private void playCh2() {
        final int[] notes = {noteA, noteB, noteBb, noteC, noteCs, noteD, noteDs, noteE, noteF, noteFs, noteG, noteGs, noteA2,
        noteB2, noteBb2, noteC2, noteCs2, noteD2, noteDs2, noteE2, noteF2, noteFs2, noteG2, noteGs2};

        String test = "note is now:" + numberPicker.getValue();
        Toast.makeText(SynthesizerActivity.this, test, Toast.LENGTH_SHORT).show();
        playNote(notes[currentCustomNote], numberPicker.getValue()-1);
    }

    private void playCh1() {
        //plays a scale from low pitch e to high pitch e
        playNote(noteE);
        delay(HALF_NOTE);
        playNote(noteFs);
        delay(HALF_NOTE);
        playNote(noteG);
        delay(HALF_NOTE);
        playNote(noteA2);
        delay(HALF_NOTE);
        playNote(noteB2);
        delay(HALF_NOTE);
        playNote(noteCs2);
        delay(HALF_NOTE);
        playNote(noteD2);
        delay(HALF_NOTE);
        playNote(noteE2);
    }

    private void playScale() {
        //play all notes one at a time with a delay in between
        Song scale = new Song();
        scale.add(new Note(noteG, HALF_NOTE));
        scale.add(new Note(noteG, HALF_NOTE));
        scale.add(new Note(noteG, HALF_NOTE));
        scale.add(new Note(noteD, HALF_NOTE));
        scale.add(new Note(noteE, HALF_NOTE));
        scale.add(new Note(noteE, HALF_NOTE));
        scale.add(new Note(noteD, WHOLE_NOTE)); //old macDonald had a farm
        scale.add(new Note(noteB2, HALF_NOTE));
        scale.add(new Note(noteB2, HALF_NOTE));
        scale.add(new Note(noteA2, HALF_NOTE));
        scale.add(new Note(noteA2, HALF_NOTE));
        scale.add(new Note(noteG, WHOLE_NOTE)); //eieio
        scale.add(new Note(noteD, HALF_NOTE));
        scale.add(new Note(noteG, HALF_NOTE));
        scale.add(new Note(noteG, HALF_NOTE));
        scale.add(new Note(noteG, HALF_NOTE));
        scale.add(new Note(noteD, HALF_NOTE));
        scale.add(new Note(noteE, HALF_NOTE));
        scale.add(new Note(noteE, HALF_NOTE));
        scale.add(new Note(noteD, WHOLE_NOTE)); //and on his farm he had a _
        scale.add(new Note(noteB2, HALF_NOTE));
        scale.add(new Note(noteB2, HALF_NOTE));
        scale.add(new Note(noteA2, HALF_NOTE));
        scale.add(new Note(noteA2, HALF_NOTE));
        scale.add(new Note(noteG)); //eieio


        playSong(scale);
    }

    private void playSong(Song song) {
        for(Note note : song.getNotes()) {
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, loop, DEFAULT_RATE);

    }

    private void playNote(int note) {
        playNote(note, 0);
    }

    private void playNote(Note note) {
        playNote(note.getNoteId(), 0);
    }

    //make an inner class to handle the button clicks
    //for the individual notes
    private class KeyboardNoteListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //get the id of the button that was clicked
            int id = v.getId();
            //use the map to figure out what note to play
            int note = noteMap.get(id);
            //play the note
            playNote(note);
        }
    }
}
