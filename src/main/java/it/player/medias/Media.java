package it.player.medias;

import lombok.Data;

@Data
public abstract class Media {
    protected String title;
    protected MediaType type;
    protected int volume = 5;
    protected int duration;
    protected int luminosità = 5;

    protected Media(String title, MediaType type) {
        this.title = title;
        this.type = type;
    }

    public abstract void play();
    public abstract void abbassaVolume();
    public abstract void alzaVolume();
    public abstract void abbassaLuminosità();
    public abstract void alzaLuminosità();
}
