package it.player.medias;

import it.player.interfaces.Play;
import it.player.interfaces.Volume;

public class Audio extends Media implements Play, Volume {
    public Audio(String title, int duration, int volume) {
        super(title, MediaType.AUDIO);
        this.volume = volume;
        this.duration = duration;
    }

    @Override
    public void play() {
        String volumeDisplay = "!".repeat(volume);

        System.out.println("Riproduco:");

        for (int i = 0; i < duration; i++) {
            System.out.println(getTitle() + " " + volumeDisplay);
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

    }

    @Override
    public void alzaLuminosità() {

    }
}
