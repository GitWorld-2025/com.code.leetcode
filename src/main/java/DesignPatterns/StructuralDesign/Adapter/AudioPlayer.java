package DesignPatterns.StructuralDesign.Adapter;

import DesignPatterns.StructuralDesign.Adapter.Adapters.Mp3Player;
import DesignPatterns.StructuralDesign.Adapter.Adapters.Mp4PlayerAdapter;
import DesignPatterns.StructuralDesign.Adapter.Adapters.VlcPlayerAdapter;
import DesignPatterns.StructuralDesign.Adapter.Legacy.Mp4Codec;
import DesignPatterns.StructuralDesign.Adapter.Legacy.VlcCodec;

class AudioPlayer {
    public void playFile(String filename) {
        MediaPlayer player;
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();

        switch (extension) {
            case "mp3":
                player = new Mp3Player();
                break;
            case "vlc":
                player = new VlcPlayerAdapter(new VlcCodec());
                break;
            case "mp4":
                player = new Mp4PlayerAdapter(new Mp4Codec());
                break;
            default:
                System.out.println("Unsupported format: " + extension);
                return;
        }

        player.play(filename);
    }
}
