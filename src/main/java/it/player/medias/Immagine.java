package it.player.medias;

import it.player.interfaces.Luminosità;

public class Immagine extends Media implements Luminosità {
        public Immagine(String title, int luminosità) {
            super(title, MediaType.IMMAGINE);
            this.luminosità = luminosità;
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

