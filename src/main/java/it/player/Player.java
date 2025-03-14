package it.player;

import it.player.interfaces.Volume;
import it.player.interfaces.Luminosità;
import it.player.medias.Audio;
import it.player.medias.Immagine;
import it.player.medias.Media;
import it.player.medias.Video;

import java.util.Scanner;

public class Player {
    public static Media[] media = new Media[3];
    private static int mediaToPlay = -1;

    public static void creaMedia(){
        for (int i = 0; i < media.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleziona il tipo di Media da creare");
            System.out.println("1 per Immagine, 2 per Audio, 3 per Video");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il titolo dell'immagine");
                    String titoloImmagine = scanner.next();
                    media[i] = new Immagine(titoloImmagine);
                    System.out.println("Immagine creata con successo");
                    System.out.println("-----------------------------");
                    break;
                case 2:
                    System.out.println("Inserisci il titolo dell'audio");
                    String titoloAudio = scanner.next();

                    System.out.println("Inserisci la durata dell'audio");
                    int durataAudio = scanner.nextInt();

                    System.out.println("Inserisci il volume dell'audio");
                    int volumeAudio = scanner.nextInt();

                    media[i] = new Audio(titoloAudio, durataAudio, volumeAudio);
                    System.out.println("Audio creato con successo");
                    System.out.println("-----------------------------");
                    break;
                case 3:
                    System.out.println("Inserisci il titolo del video");
                    String titoloVideo = scanner.next();

                    System.out.println("Inserisci la durata del video");
                    int durataVideo = scanner.nextInt();

                    System.out.println("Inserisci il volume del video");
                    int volumeVideo = scanner.nextInt();

                    System.out.println("Inserisci la luminosità del video");
                    int luminositàVideo = scanner.nextInt();

                    media[i] = new Video(titoloVideo, durataVideo, volumeVideo, luminositàVideo);
                    System.out.println("Video creato con successo");
                    System.out.println("-----------------------------");
                    break;
            }
        }

        mediaList();
    }


    public static void mediaList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli il media da riprodurre, 0 per uscire.");
        for (int i = 0; i < media.length; i++) {
            System.out.println(i + 1 + " " + media[i].getTitle());
        }

        mediaToPlay = scanner.nextInt() - 1;

        if (mediaToPlay >= 0 && mediaToPlay < media.length) {
            if(media[mediaToPlay] instanceof Immagine) {
                ((Immagine) media[mediaToPlay]).show();
            } else {
                media[mediaToPlay].play();
                edit();
            }
        } else if (mediaToPlay + 1 == 0) {
            System.out.println("Chiusura Player...");
            System.exit(0);
        } else {
            System.out.println("Media non disponibile");
        };
    }

    public static void edit() {
        Scanner scanner = new Scanner(System.in);

        if(media[mediaToPlay] instanceof Volume && !(media[mediaToPlay] instanceof Luminosità)) {
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
        } else if (media[mediaToPlay] instanceof Luminosità && !(media[mediaToPlay] instanceof Volume)) {
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

        } else if (media[mediaToPlay] instanceof Luminosità && media[mediaToPlay] instanceof Volume) {
            System.out.println("Vuoi modificare il volume o la luminosità?");
            System.out.println("V per volume, L per luminosità, N per continuare, 0 per uscire");
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
            System.out.println("1 per alzare il volume, 2 per abbassare il volume (Min:0 Max:10)");
            System.out.println("Volume attuale: " + media[mediaToPlay].getVolume());
            int richiestaVolume2 = scanner.nextInt();
            switch (richiestaVolume2) {
                case 1:
                    if (media[mediaToPlay].getVolume() < 10) {
                        media[mediaToPlay].alzaVolume();
                    } else {
                        System.out.println("Il volume è già al massimo.");
                    }
                    media[mediaToPlay].play();
                    edit();
                    break;
                    case 2:
                        if (media[mediaToPlay].getVolume() > 0) {
                            media[mediaToPlay].abbassaVolume();
                        } else {
                            System.out.println("Il volume è già al minimo.");
                        }
                        media[mediaToPlay].play();
                        edit();
                        break;
                        case 0:
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
                        System.out.println("Scrivi Alza per alzare la luminosità o Abbassa per abbassare la luminosità (Min:0 Max:10)");
                        System.out.println("Luminosità attuale: " + media[mediaToPlay].getLuminosità());
                        int richiestaLuminosità2 = scanner.nextInt();

            switch (richiestaLuminosità2) {
                case 1:
                    if (media[mediaToPlay].getLuminosità() < 10) {
                        media[mediaToPlay].alzaLuminosità();
                    } else {
                        System.out.println("La luminosità è già al massimo.");
                    }
                    if(media[mediaToPlay] instanceof Immagine) {
                        ((Immagine) media[mediaToPlay]).show();
                        edit();
                    } else {
                        media[mediaToPlay].play();
                        edit();
                    }
                    break;
                case 2:
                    if (media[mediaToPlay].getLuminosità() > 0) {
                        media[mediaToPlay].abbassaLuminosità();
                    } else {
                        System.out.println("La luminosità è già al minimo.");
                    }
                    if(media[mediaToPlay] instanceof Immagine) {
                        ((Immagine) media[mediaToPlay]).show();
                        edit();
                    } else {
                        media[mediaToPlay].play();
                        edit();
                    }
                    break;
                case 0:
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
