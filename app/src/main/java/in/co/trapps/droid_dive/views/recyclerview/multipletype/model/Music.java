package in.co.trapps.droid_dive.views.recyclerview.multipletype.model;

import in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants;
import org.jetbrains.annotations.NotNull;

/**
 * @author Akash Patra
 */
public class Music implements BaseModel {

    private String band;
    private String song;

    public Music(@NotNull String band, @NotNull String song) {
        this.band = band;
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public String getBand() {
        return band;
    }

    @Override
    public int getViewType() {
        return Constants.ViewType.MUSIC;
    }
}
