package it.player.player;

import it.player.medias.Immagine;

import java.util.Scanner;

import static it.player.player.Edit.edit;
import static it.player.player.Player.media;
import static it.player.player.Player.mediaToPlay;

public class MediaList {
    public static void mediaList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli il media da riprodurre, 0 per uscire.");
        for (int i = 0; i < media.length; i++) {
            System.out.println(i + 1 + " " + media[i].getTitle() + " " + media[i].getType());
        }

        mediaToPlay = scanner.nextInt() - 1;

        if ( mediaToPlay >= 0 &&  mediaToPlay < media.length) {
            if(media[ mediaToPlay] instanceof Immagine) {
                ((Immagine) media[ mediaToPlay]).show();
                edit();
            } else {
                media[ mediaToPlay].play();
                edit();
            }
        } else if ( mediaToPlay + 1 == 0) {
            System.out.println("Chiusura Player...");
            System.exit(0);
        } else {
            System.out.println("Media non disponibile");
        };
    }
}
