package marioaks.entertainmentApp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import marioaks.search.R;

/**
 * Created by rajmehta on 2/23/16.
 */
public class View_Holder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView title;
    TextView progress;
    ImageView media;
    ProgressBar pbar;
    TextView date;

    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.card_view);
        title = (TextView) itemView.findViewById(R.id.title);
        progress = (TextView) itemView.findViewById(R.id.percent_number);
        media = (ImageView) itemView.findViewById(R.id.media);
        pbar = (ProgressBar) itemView.findViewById(R.id.pbar);
        date = (TextView) itemView.findViewById(R.id.date);
    }
}
