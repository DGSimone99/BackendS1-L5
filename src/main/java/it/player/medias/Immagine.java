package it.player.medias;

import it.player.interfaces.Luminosità;
import it.player.interfaces.Play;

public class Immagine extends Media implements Luminosità {
        public Immagine(String title) {
            super(title, MediaType.IMMAGINE);
            this.luminosità = 5;
        }

        public void show() {
            String luminositàDisplay = "*".repeat(luminosità);

            System.out.println("Visualizzo:");

            System.out.println(getTitle() + " " + luminositàDisplay);
        }

    @Override
    public void play() {

    }

    @Override
    public void abbassaVolume() {

    }

    @Override
    public void alzaVolume() {

    }

    @Override
    public void abbassaLuminosità() {
            luminosità--
            ;}
    @Override
    public void alzaLuminosità() {
            luminosità++
            ;}

}

