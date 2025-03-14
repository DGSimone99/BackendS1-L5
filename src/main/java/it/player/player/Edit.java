package it.player.player;

import it.player.medias.Audio;
import it.player.medias.Immagine;
import it.player.medias.Video;

import java.util.Scanner;

import static it.player.player.MediaList.mediaList;
import static it.player.player.Player.media;
import static it.player.player.Player.mediaToPlay;

public class Edit {
    public static void edit() {
        Scanner scanner = new Scanner(System.in);

        if(media[mediaToPlay] instanceof Audio) {
            System.out.println("Vuoi modificare il volume? s/n");
            System.out.println("Volume attuale: " + media[mediaToPlay].getVolume());
            String scelta = scanner.next();

            switch (scelta.toLowerCase()) {
                case "s":
                    controlVolume();
                    break;
                case "n":
                    mediaList();
                    break;
                case "0":
                    System.out.println("Chiusura Player...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando non valido");
                    edit();
                    break;
            }
        } else if (media[mediaToPlay] instanceof Immagine) {
            System.out.println("Vuoi modificare la luminosità? s/n");
            String scelta = scanner.next();
            switch (scelta.toLowerCase()) {
                case "s":
                    controlLuminosità();
                    break;
                case "n":
                    mediaList();
                    break;
                case "0":
                    System.out.println("Chiusura Player...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando non valido");
                    edit();
                    break;
            }

        } else if (media[mediaToPlay] instanceof Video) {
            System.out.println("Vuoi modificare il volume o la luminosità?");
            System.out.println("V: Volume");
            System.out.println("L: Luminosità");
            System.out.println("N: Esci");
            String scelta = scanner.next();
            switch (scelta.toLowerCase()) {
                case "l":
                    controlLuminosità();
                    break;
                case "v":
                    controlVolume();
                    break;
                case "n":
                    mediaList();
                    break;
                case "0":
                    System.out.println("Chiusura Player...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando non valido");
                    edit();
                    break;
            }
        }
    }

    public static void controlVolume() {
        Scanner scanner = new Scanner(System.in);

        if (mediaToPlay >= 0 && mediaToPlay < media.length) {
            System.out.println("1: Alza il volume (Max: 10)");
            System.out.println("2: Abbassa il volume (Min: 0)");
            System.out.println("N: Esci");
            System.out.println("Volume attuale: " + media[mediaToPlay].getVolume());
            String richiestaVolume2 = scanner.next();

            switch (richiestaVolume2) {
                case "1":
                    if (media[mediaToPlay].getVolume() < 10) {
                        media[mediaToPlay].alzaVolume();
                    } else {
                        System.out.println("Il volume è già al massimo.");
                    }
                    media[mediaToPlay].play();
                    controlVolume();
                    break;
                case "2":
                    if (media[mediaToPlay].getVolume() > 0) {
                        media[mediaToPlay].abbassaVolume();
                    } else {
                        System.out.println("Il volume è già al minimo.");
                    }
                    media[mediaToPlay].play();
                    controlVolume();
                    break;

                case "n":
                    mediaList();
                    break;

                case "0":
                    System.out.println("Chiusura Player...");
                    System.exit(0);
                    break;
                default: System.out.println("Comando non valido");
                    media[mediaToPlay].play();
                    controlVolume();
                    break;
            }
        }
    }

    public static void controlLuminosità() {
        Scanner scanner = new Scanner(System.in);

        if (mediaToPlay >= 0 && mediaToPlay < media.length) {
            System.out.println("1: Alza la luminosità (Max: 10)");
            System.out.println("2: Abbassa la luminosità (Min: 0)");
            System.out.println("N: Esci");
            System.out.println("Luminosità attuale: " + media[mediaToPlay].getLuminosità());
            String richiestaLuminosità2 = scanner.next();

            switch (richiestaLuminosità2) {
                case "1":
                    if (media[mediaToPlay].getLuminosità() < 10) {
                        media[mediaToPlay].alzaLuminosità();
                    } else {
                        System.out.println("La luminosità è già al massimo.");
                    }
                    if (media[mediaToPlay] instanceof Immagine) {
                        ((Immagine) media[mediaToPlay]).show();
                        controlLuminosità();
                    } else {
                        media[mediaToPlay].play();
                        controlLuminosità();
                    }
                    break;

                case "2":
                    if (media[mediaToPlay].getLuminosità() > 0) {
                        media[mediaToPlay].abbassaLuminosità();
                    } else {
                        System.out.println("La luminosità è già al minimo.");
                    }
                    if (media[mediaToPlay] instanceof Immagine) {
                        ((Immagine) media[mediaToPlay]).show();
                        controlLuminosità();
                    } else {
                        media[mediaToPlay].play();
                        controlLuminosità();
                    }
                    break;

                case "n":
                    mediaList();
                    break;

                case "0":
                    System.out.println("Chiusura Player...");
                    System.exit(0);
                    break;



                default: System.out.println("Comando non valido");
                    if(media[mediaToPlay] instanceof Immagine) {
                        ((Immagine) media[mediaToPlay]).show();
                        edit();
                    } else {
                        media[mediaToPlay].play();
                        edit();
                    }
                    edit();
                    break;
            }
        }
    }
}
