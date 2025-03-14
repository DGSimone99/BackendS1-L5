package it.player.medias;

import it.player.interfaces.Luminosità;
import it.player.interfaces.Play;
import it.player.interfaces.Volume;

public class Video extends Media implements Play, Volume, Luminosità {
    public Video(String title, int duration, int volume, int luminosità) {
        super(title, MediaType.VIDEO);
        this.volume = volume;
        this.duration = duration;
        this.luminosità = luminosità;
    }

    @Override
    public void play() {
        String volumeDisplay = "!".repeat(volume);
        String luminositàDisplay = "*".repeat(luminosità);

        System.out.println("Riproduco:");

        for (int i = 0; i < duration; i++) {
            System.out.println(getTitle() + " " + volumeDisplay + " " + luminositàDisplay);
        }
    }

    @Override
    public void abbassaVolume() {
        volume--;
    }

    @Override
    public void alzaVolume() {
        volume++;

    }

    @Override
    public void abbassaLuminosità() {
        luminosità--;
    }

    @Override
    public void alzaLuminosità() {
        luminosità++;

    }

}
