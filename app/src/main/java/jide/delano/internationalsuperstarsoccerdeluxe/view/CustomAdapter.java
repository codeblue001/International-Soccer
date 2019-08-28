package jide.delano.internationalsuperstarsoccerdeluxe.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import jide.delano.internationalsuperstarsoccerdeluxe.R;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;


public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<MatchResult> dataSet;
    private ItemClickEvent listener;

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
        holder.onBind(dataSet.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;    }
}
