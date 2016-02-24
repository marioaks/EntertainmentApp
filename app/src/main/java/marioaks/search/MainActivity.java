package marioaks.search;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


}