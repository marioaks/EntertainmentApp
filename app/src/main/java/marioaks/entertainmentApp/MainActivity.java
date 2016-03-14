package marioaks.entertainmentApp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.text.DateFormat;
import java.util.Date;

import marioaks.entertainmentApp.R;

public class MainActivity extends AppCompatActivity {

    public static String selection = "Feed";
    private ViewAnimator subscreen;
    private RecyclerView recyclerView;
    private Recycler_View_Adapter adapter;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        adapter = new Recycler_View_Adapter(getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       /* TextView text2 = new TextView(this);
        TextView text3 = new TextView(this);
        TextView text4 = new TextView(this);

        text2.setText("This is where the reviews will be.");
        text3.setText("This is where the followers will be.");
        text4.setText("This is where the following will be.");

        subscreen = (ViewAnimator) findViewById(R.id.viewAnimator);
        subscreen.addView(text2, -1);
        subscreen.addView(text4, -1);
        subscreen.addView(text3, -1);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        ((SearchView) (menu.findItem(R.id.menu_search).getActionView())).
                setSearchableInfo(((SearchManager) getSystemService(Context.SEARCH_SERVICE)).
                        getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
           // case R.id.my_library_screen:
             //   return true;
            case R.id.my_profile_screen:
                return true;
           /* case R.id.home_screen:
                return true;
            case R.id.logout:
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showScreen(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.profile_spinner);
        //spinner.setOnItemSelectedListener(this);
        switch (selection) {
            case "Feed":
                subscreen.setDisplayedChild(0);
                break;
            case "Reviews":
                subscreen.setDisplayedChild(1);
                break;
            case "Following":
                subscreen.setDisplayedChild(2);
                break;
            case "Followers":
                subscreen.setDisplayedChild(3);
                break;
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selection = (String) parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }

    public void onLibraryButtonClick(View view) {
        Intent i = new Intent(this, LibraryActivity.class);
        startActivityForResult(i, 1);
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