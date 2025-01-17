package me.ag2s.tts.services;


import android.media.AudioFormat;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class TtsConfig {
    private final boolean sentenceBoundaryEnabled;
    @SuppressWarnings("FieldCanBeLocal")
    private final boolean wordBoundaryEnabled;
    //private final String audioFormat;
    private final int index;
    private final String Raw16Khz16BitMonoPcm = "raw-16khz-16bit-mono-pcm";
    private final String Raw16Khz16BitMonoTrueSilk = "raw-16khz-16bit-mono-truesilk";
    private final String Raw24Khz16BitMonoPcm = "raw-24khz-16bit-mono-pcm";
    private final String Raw48Khz16BitMonoPcm = "raw-48khz-16bit-mono-pcm";
    private final String Raw8Khz16BitMonoPcm = "raw-8khz-16bit-mono-pcm";
    private final String Raw8Khz8BitMonoMULaw = "raw-8khz-8bit-mono-mulaw";

    private final List<TtsOutputFormat> formats;


    private TtsConfig(Builder builder) {
        this.sentenceBoundaryEnabled = builder.sentenceBoundaryEnabled;
        this.wordBoundaryEnabled = builder.wordBoundaryEnabled;
        //this.audioFormat = builder.audioFormat;
        this.index = builder.index;
        this.formats = new ArrayList<>();
        this.formats.add(new TtsOutputFormat("raw-16khz-16bit-mono-pcm", "raw-16khz-16bit-mono-pcm", 16000, AudioFormat.ENCODING_PCM_16BIT));
        this.formats.add(new TtsOutputFormat("raw-24khz-16bit-mono-pcm", "raw-24khz-16bit-mono-pcm", 24000, AudioFormat.ENCODING_PCM_16BIT));
        this.formats.add(new TtsOutputFormat("raw-48khz-16bit-mono-pcm", "raw-48khz-16bit-mono-pcm", 48000, AudioFormat.ENCODING_PCM_16BIT));
        this.formats.add(new TtsOutputFormat("raw-8khz-16bit-mono-pcm", "raw-8khz-16bit-mono-pcm", 8000, AudioFormat.ENCODING_PCM_16BIT));

    }

    public TtsOutputFormat getFormat() {
        return this.formats.get(index);
    }


    @NotNull
    @Override
    public String toString() {
        String msg = "{\"context\":{\"synthesis\":{\"audio\":{\"metadataoptions\":{\"sentenceBoundaryEnabled\":\"%s\",\"wordBoundaryEnabled\":\"%s\"},\"outputFormat\":\"%s\"}}}}";
        msg = String.format(msg, sentenceBoundaryEnabled ? "true" : "false", "true", this.formats.get(index).value);
        Log.d(TTSService.class.getSimpleName(), msg);
        return msg;
    }


    public static class Builder {
        //        private final String Audio16Khz128KBitRateMonoMp3 = "audio-16khz-128kbitrate-mono-mp3";
//        private final String Audio16Khz16KbpsMonoSiren = "audio-16khz-16kbps-mono-siren";
//        private final String Audio16Khz32KBitRateMonoMp3 = "audio-16khz-32kbitrate-mono-mp3";
//        private final String Audio16Khz64KBitRateMonoMp3 = "audio-16khz-64kbitrate-mono-mp3";
//        private final String Audio24Khz160KBitRateMonoMp3 = "audio-24khz-160kbitrate-mono-mp3";
//        private final String Audio24Khz48KBitRateMonoMp3 = "audio-24khz-48kbitrate-mono-mp3";
//
//        private final String Audio24Khz96KBitRateMonoMp3 = "audio-24khz-96kbitrate-mono-mp3";
//        private final String Audio48Khz192KBitRateMonoMp3 = "audio-48khz-192kbitrate-mono-mp3";
//        private final String Audio48Khz96KBitRateMonoMp3 = "audio-48khz-96kbitrate-mono-mp3";
//        private final String Ogg16Khz16BitMonoOpus = "ogg-16khz-16bit-mono-opus";
//        private final String Ogg24Khz16BitMonoOpus = "ogg-24khz-16bit-mono-opus";
//        private final String Ogg48Khz16BitMonoOpus = "ogg-48khz-16bit-mono-opus";

//        private final String Riff16Khz16BitMonoPcm = "riff-16khz-16bit-mono-pcm";
//        private final String Riff16Khz16KbpsMonoSiren = "riff-16khz-16kbps-mono-siren";
//        private final String Riff24Khz16BitMonoPcm = "riff-24khz-16bit-mono-pcm";
//        private final String Riff48Khz16BitMonoPcm = "riff-48khz-16bit-mono-pcm";
//        private final String Riff8Khz16BitMonoPcm = "riff-8khz-16bit-mono-pcm";
//        private final String Riff8Khz8BitMonoMULaw = "riff-8khz-8bit-mono-mulaw";
//        private final String Webm16Khz16BitMonoOpus = "webm-16khz-16bit-mono-opus";
//        private final String Webm24Khz16BitMonoOpus = "webm-24khz-16bit-mono-opus";

//        private final String Raw16Khz16BitMonoPcm = "raw-16khz-16bit-mono-pcm";
//        private final String Raw16Khz16BitMonoTrueSilk = "raw-16khz-16bit-mono-truesilk";
//        private final String Raw24Khz16BitMonoPcm = "raw-24khz-16bit-mono-pcm";
//        private final String Raw48Khz16BitMonoPcm = "raw-48khz-16bit-mono-pcm";
//        private final String Raw8Khz16BitMonoPcm = "raw-8khz-16bit-mono-pcm";
//        private final String Raw8Khz8BitMonoMULaw = "raw-8khz-8bit-mono-mulaw";


        public static enum Format {
            Raw8Khz8BitMonoMULaw,
            Raw8Khz16BitMonoPcm,
            Raw16Khz16BitMonoPcm,
            Raw16Khz16BitMonoTrueSilk,
            Raw24Khz16BitMonoPcm,
            Raw48Khz16BitMonoPcm,
        }

        ;
        //        public String audioFormat = Raw48Khz16BitMonoPcm;
        private boolean sentenceBoundaryEnabled = false;
        private boolean wordBoundaryEnabled = true;
        private int index = 0;

        public TtsConfig build() {
            return new TtsConfig(this);
        }

        public Builder(int index) {
            this.index = index;
        }
//        public Builder setFormat(Format format){
//            this.audioFormat=format.name();
//            return this;
//        }

        public Builder sentenceBoundaryEnabled(boolean sentenceBoundaryEnabled) {
            this.sentenceBoundaryEnabled = sentenceBoundaryEnabled;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder wordBoundaryEnabled(boolean wordBoundaryEnabled) {
            this.wordBoundaryEnabled = wordBoundaryEnabled;
            return this;
        }

    }

}
