package in.co.trapps.droid_dive.views.recyclerview.multipletype.model;

import in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants;

/**
 * @author Akash Patra
 */
public class PodCast implements BaseModel {

    private String developer;
    private String topic;

    public PodCast(String developer, String topic) {
        this.developer = developer;
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public String getDeveloper() {
        return developer;
    }

    @Override
    public int getViewType() {
        return Constants.ViewType.POD_CAST;
    }
}
