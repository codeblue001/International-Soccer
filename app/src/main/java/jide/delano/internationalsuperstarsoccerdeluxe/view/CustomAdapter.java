package jide.delano.internationalsuperstarsoccerdeluxe.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import jide.delano.internationalsuperstarsoccerdeluxe.R;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;


public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<MatchResult> dataSet;
    private static final String TAG = "CustomAdapter";
    private Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    public void setDataSet(List<MatchResult> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.matchTitle.setText(dataSet.get(position).getTitle());
        holder.competitionName.setText(dataSet.get(position).getCompetition().getName());
        holder.matchDate.setText(dataSet.get(position).getDate());
        Picasso.get().load(dataSet.get(position).getThumbnail()).into(holder.matchImage);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }

}
