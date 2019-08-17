package in.co.trapps.droid_dive.views.recyclerview.multipletype.model;

import in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants;
import org.jetbrains.annotations.NotNull;

/**
 * @author Akash Patra
 */
public class Movie implements BaseModel {

    private String actor;
    private String title;

    public Movie(@NotNull String actor, @NotNull String title) {
        this.actor = actor;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getActor() {
        return actor;
    }

    @Override
    public int getViewType() {
        return Constants.ViewType.MOVIE;
    }
}
