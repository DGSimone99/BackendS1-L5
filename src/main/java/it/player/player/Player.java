package it.player.player;

import it.player.medias.Audio;
import it.player.medias.Immagine;
import it.player.medias.Media;
import it.player.medias.Video;
import lombok.Data;

import java.util.Scanner;

import static it.player.player.MediaList.mediaList;
@Data
public class Player {
    public static Media[] media = new Media[5];
    public static int mediaToPlay = -1;

    public static void creaMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli se creare una playlist o utilizzare una già creata.");
        System.out.println("1: Crea Playlist.");
        System.out.println("2: Usa Playlist esistente.");
        System.out.println("0: Chiudi il player.");

        String sceltaPlaylist = scanner.next();

        switch (sceltaPlaylist) {
            case "1":
                for (int i = 0; i < media.length; i++) {
                    System.out.println("Seleziona il tipo di Media da creare");
                    System.out.println("1: Immagine");
                    System.out.println("2: Audio");
                    System.out.println("3: Video");
                    System.out.println("0: Chiudi");
                    String scelta = scanner.next();
                    scanner.nextLine();

                    switch (scelta) {
                        case "1":
                            System.out.println("Inserisci il titolo dell'immagine");
                            String titoloImmagine = scanner.next();

                            System.out.println("Inserisci la luminosità dell'immagine");
                            int luminositàImmagine = scanner.nextInt();

                            media[i] = new Immagine(titoloImmagine, luminositàImmagine);
                            System.out.println("Immagine creata con successo");
                            System.out.println("-----------------------------");
                            break;

                        case "2":
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

                        case "3":
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
                        case "0": System.exit(0);
                }
            }
            break;
            case "2":
                media = new Media[5];
                media[0] = new Immagine("Immagine1", 4);
                media[1] = new Video("Video", 4, 5, 3);
                media[2] = new Audio("Musica1", 4, 5);
                media[3] = new Audio("Musica2", 4, 5);
                media[4] = new Video("Immagine1", 4, 5, 4);
                break;
            default:
                System.out.println("Comando non valido");
                creaMedia();
                break;
            }


        mediaList();
        }
    }
