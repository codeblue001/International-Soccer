package jide.delano.internationalsuperstarsoccerdeluxe.view;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import jide.delano.internationalsuperstarsoccerdeluxe.R;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;


public class CustomViewHolder extends RecyclerView.ViewHolder  {

    private CardView cardView;
    private ImageView matchImage;
    private TextView matchTitle;
    private TextView competitionName;
    private TextView matchDate;
    private Context context;
    private MatchResult matchResult;


    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cv_match);
        matchImage = itemView.findViewById(R.id.iv_match_thumbnail);
        matchTitle = itemView.findViewById(R.id.tv_title);
        competitionName = itemView.findViewById(R.id.tv_competition_name);
        matchDate = itemView.findViewById(R.id.tv_match_date);
        context = itemView.getContext();
    }

    public  void onBind(final MatchResult response, final ItemClickEvent listener) {
        String time = response.getDate();
        String formattedTime = time.substring(0,10) + " " + time.substring(11,19);
        matchDate.setText(formattedTime);
        matchTitle.setText(response.getTitle());
        competitionName.setText(response.getCompetition().getName());
        Picasso.get().load(response.getThumbnail()).into(matchImage);
        matchResult = response;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("jsonResponse", matchResult);
                context.startActivity(intent);
            }
        });
    }

}