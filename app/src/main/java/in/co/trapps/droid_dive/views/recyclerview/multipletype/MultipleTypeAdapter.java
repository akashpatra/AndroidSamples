package in.co.trapps.droid_dive.views.recyclerview.multipletype;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.co.trapps.droid_dive.R;
import in.co.trapps.droid_dive.views.recyclerview.multipletype.model.BaseModel;
import in.co.trapps.droid_dive.views.recyclerview.multipletype.model.Movie;
import in.co.trapps.droid_dive.views.recyclerview.multipletype.model.Music;
import in.co.trapps.droid_dive.views.recyclerview.multipletype.model.PodCast;

import java.util.List;

import static in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants.TAG;
import static in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants.ViewType.*;

/**
 * @author Akash Patra
 */
public class MultipleTypeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<? extends BaseModel> data;
    private LayoutInflater mInflater;

    public MultipleTypeAdapter(List<? extends BaseModel> data, Context context) {
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder -> ViewType: " + viewType);

        BaseViewHolder holder;
        switch (viewType) {
            case MOVIE:
                holder = new MovieHolder(mInflater.inflate(R.layout.item_movie, parent, false));
                break;
            case MUSIC:
                holder = new MusicHolder(mInflater.inflate(R.layout.item_music, parent, false));
                break;
            case POD_CAST:
                holder = new PodCastHolder(mInflater.inflate(R.layout.item_podcast, parent, false));
                break;
            default:
                holder = new MovieHolder(mInflater.inflate(R.layout.item_movie, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");

        holder.bind(data.get(position));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
//        Log.d(TAG, "getItemCount");

        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
//        Log.d(TAG, "getItemViewType");

        return data.get(position).getViewType();
    }

    public static class MovieHolder extends BaseViewHolder<Movie> {

        private TextView tvActor, tvTitle;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            tvActor = itemView.findViewById(R.id.tv_actor);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }

        @Override
        public void bind(Movie movie) {
            tvActor.setText(movie.getActor());
            tvTitle.setText(movie.getTitle());
        }
    }

    public static class MusicHolder extends BaseViewHolder<Music> {

        private TextView tvBand, tvSong;

        public MusicHolder(@NonNull View itemView) {
            super(itemView);
            tvBand = itemView.findViewById(R.id.tv_band);
            tvSong = itemView.findViewById(R.id.tv_song);
        }

        @Override
        public void bind(Music music) {
            tvBand.setText(music.getBand());
            tvSong.setText(music.getSong());
        }
    }

    public static class PodCastHolder extends BaseViewHolder<PodCast> {

        private TextView tvDeveloper, tvTopic;

        public PodCastHolder(@NonNull View itemView) {
            super(itemView);
            tvDeveloper = itemView.findViewById(R.id.tv_developer);
            tvTopic = itemView.findViewById(R.id.tv_topic);
        }

        @Override
        public void bind(PodCast podCast) {
            tvDeveloper.setText(podCast.getDeveloper());
            tvTopic.setText(podCast.getTopic());
        }
    }


}
