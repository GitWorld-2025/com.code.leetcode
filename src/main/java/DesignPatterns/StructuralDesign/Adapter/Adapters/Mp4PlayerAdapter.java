package DesignPatterns.StructuralDesign.Adapter.Adapters;

import DesignPatterns.StructuralDesign.Adapter.Legacy.Mp4Codec;
import DesignPatterns.StructuralDesign.Adapter.MediaPlayer;

public class Mp4PlayerAdapter implements MediaPlayer {
    private final Mp4Codec codec;

    public Mp4PlayerAdapter(Mp4Codec codec) {
        this.codec = codec;
    }

    @Override
    public void play(String filename) {
        codec.playMp4(filename);
    }
}
