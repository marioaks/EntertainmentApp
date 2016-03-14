package marioaks.entertainmentApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import marioaks.entertainmentApp.R;

public class LibraryAdderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_adder);
    }

    public void onBackButtonClick(View view) {
        finish();
    }

    public void onSaveButtonClick(View view) {
        EditText title = (EditText) findViewById(R.id.library_adder_title);
        Spinner type = (Spinner) findViewById(R.id.library_adder_spinner);
        EditText genre = (EditText) findViewById(R.id.library_adder_genre);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.library_adder_rating);
        EditText review = (EditText) findViewById(R.id.library_adder_review);

        LibraryEntry entry = new LibraryEntry(title.getText().toString(),
                type.getSelectedItem().toString(), genre.getText().toString(),
                (double) ratingBar.getRating(), review.getText().toString());
        LibraryDatabase database = LibraryDatabase.getInstance();
        database.add(entry);

        finish();
    }
}
