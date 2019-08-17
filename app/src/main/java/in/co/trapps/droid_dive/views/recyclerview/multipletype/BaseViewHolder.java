package in.co.trapps.droid_dive.views.recyclerview.multipletype;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.co.trapps.droid_dive.views.recyclerview.multipletype.model.BaseModel;

/**
 * @author Akash Patra
 */
public abstract class BaseViewHolder<T extends BaseModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(T object);
}
