package marioaks.entertainmentApp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import marioaks.entertainmentApp.R;

public class TileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Recycler_View_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tile);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        adapter = new Recycler_View_Adapter(getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onEnterButtonClick(View view) {
        Spinner mediaSpinner = (Spinner) findViewById(R.id.media_type);
        String mediaType = mediaSpinner.getSelectedItem().toString();

        EditText mediaText = (EditText)findViewById(R.id.title);
        String titleOfMedia = mediaText.getText().toString();

        Spinner percentSpinner = (Spinner) findViewById(R.id.percent);

        String percentFinished = percentSpinner.getSelectedItem().toString();
        if (!percentFinished.equals("Progress")) {
            int percentIndex = percentFinished.indexOf("%");
            String percent = percentFinished.substring(0, percentIndex);
            int percentNumber = Integer.parseInt(percent);
            String date = getDate();

            if (titleOfMedia != null && !titleOfMedia.equals("")) {
                switch (mediaType) {
                    case "Cinema":
                        adapter.insert(0, new Data(titleOfMedia,
                                percentFinished, percentNumber, R.drawable.cinema, date));
                        break;
                    case "Literature":
                        adapter.insert(0, new Data(titleOfMedia,
                                percentFinished, percentNumber, R.drawable.book, date));
                        break;
                    case "Television":
                        adapter.insert(0, new Data(titleOfMedia,
                                percentFinished, percentNumber, R.drawable.television, date));
                        break;
                    case "Music":
                        adapter.insert(0, new Data(titleOfMedia,
                                percentFinished, percentNumber, R.drawable.music, date));
                        break;
                    default:
                        Context context = getApplicationContext();
                        CharSequence text = "Please Select a Media Type!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                }
                mediaText.setText("");
                //mediaSpinner.setSelection(R.string.media_default);
                //percentSpinner.setSelection(R.string.percent_default);
            }
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Please Indicate Your Progress!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private String getDate() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        Date date = new Date();
        return dateFormat.format(date);
    }

}
