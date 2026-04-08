package DesignPatterns.StructuralDesign.Adapter.Adapters;

import DesignPatterns.StructuralDesign.Adapter.Legacy.VlcCodec;
import DesignPatterns.StructuralDesign.Adapter.MediaPlayer;

public class VlcPlayerAdapter implements MediaPlayer {
    private final VlcCodec codec;

    public VlcPlayerAdapter(VlcCodec codec) {
        this.codec = codec;
    }

    @Override
    public void play(String filename) {
        codec.playVlc(filename);
    }
}