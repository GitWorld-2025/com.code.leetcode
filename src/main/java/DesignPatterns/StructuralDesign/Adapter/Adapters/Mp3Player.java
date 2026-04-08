package DesignPatterns.StructuralDesign.Adapter.Adapters;

import DesignPatterns.StructuralDesign.Adapter.MediaPlayer;

public class Mp3Player implements MediaPlayer {
    @Override
    public void play(String filename) {
        System.out.println("MP3 Player: Playing " + filename);
    }
}
