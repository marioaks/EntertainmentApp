package marioaks.entertainmentApp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import marioaks.search.R;

public class Search extends AppCompatActivity {
    //private static final String API_KEY = "5";
    //private static final int MOVIE_PAGE_LIMIT = 10;
    //private ListView moviesList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        addStringToIntent(getIntent());
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
    public void onNewIntent(Intent intent) {
        addStringToIntent(intent);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
    }

    private void addStringToIntent(Intent i) {
        if (i.getAction().equals(Intent.ACTION_SEARCH)) {
            String wordTyped = i.getStringExtra(SearchManager.QUERY);
            performSearch(wordTyped);
        }
    }

    private void performSearch(String wordTyped) {
        /*TextView t = (TextView) findViewById(R.id.textView);
        t.setText(wordTyped);
        System.out.println(wordTyped);
        new RequestTask().execute(
                "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey="
                + API_KEY + "&q=" + queryStr
                + "&page_limit=" + MOVIE_PAGE_LIMIT);*/
    }
}