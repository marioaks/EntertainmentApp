package marioaks.entertainmentApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import marioaks.entertainmentApp.R;

public class LibraryActivity extends AppCompatActivity {

    LibraryDatabase database = LibraryDatabase.getInstance();
    List<LibraryEntry> library;
    Spinner spinner;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        library = database.getAll();

        spinner = (Spinner) findViewById(R.id.library_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id) {
                spinnerSort();
                renderList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        list = (ListView) findViewById(R.id.library_listView);
        renderList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
         /*   case R.id.library_menu_all:
                library = database.getAll();
                spinnerSort();
                renderList();
                return true;
            case R.id.library_menu_books:
                library = database.getBooks();
                spinnerSort();
                renderList();
                return true;
            case R.id.library_menu_movies_tv:
                library = database.getMoviesandTV();
                spinnerSort();
                renderList();
                return true;
            case R.id.library_menu_music:
                library = database.getMusic();
                spinnerSort();
                renderList();
                return true;*/
            case R.id.my_profile_screen:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void spinnerSort() {
        switch (spinner.getSelectedItem().toString()) {
            case "Alphabetical":
                Collections.sort(library, LibraryComparator.BY_NAME);
                break;
            case "Finish Date":
                Collections.sort(library, LibraryComparator.BY_DATE_COMPLETED);
                break;
            case "Genre":
                Collections.sort(library, LibraryComparator.BY_GENRE);
                break;
            case "Rating":
                Collections.sort(library, LibraryComparator.BY_RATING);
                break;
        }
    }

    private void renderList() {
        ArrayList<String> titles = new ArrayList<String>();
        for (LibraryEntry entry : library) {
            titles.add(entry.name);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                                                    titles);
        list.setAdapter(arrayAdapter);
    }

    public void onButtonClick(View view) {
        Intent i = new Intent(this, LibraryAdderActivity.class);
        startActivity(i);
    }
}
