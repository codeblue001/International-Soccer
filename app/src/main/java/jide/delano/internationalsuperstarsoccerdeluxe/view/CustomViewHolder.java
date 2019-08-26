package jide.delano.internationalsuperstarsoccerdeluxe.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jide.delano.internationalsuperstarsoccerdeluxe.R;


public class CustomViewHolder extends RecyclerView.ViewHolder {

    ImageView matchImage;
    TextView matchTitle;
    TextView competitionName;
    TextView matchDate;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        matchImage = itemView.findViewById(R.id.iv_match_thumbnail);
        matchTitle = itemView.findViewById(R.id.tv_title);
        competitionName = itemView.findViewById(R.id.tv_competition_name);
        matchDate = itemView.findViewById(R.id.tv_match_date);
    }

}