package com.imagine.mohamedtaha.store.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.data.TableHelper;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class TableDaliyMovmentes extends AppCompatActivity implements SearchView.OnQueryTextListener {
    TableView<String[]> tb;
    TableHelper tableHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_daliy_movmentes);
        tableHelper = new TableHelper(this);
        tb = (TableView<String[]>) findViewById(R.id.tableView);
        tb.setColumnCount(6);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        tb.setHeaderBackground(R.color.colorPrimary);
        tb.setBackgroundResource(R.color.colorAccent);
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableHelper.getSpaceProbeHEaders()));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, tableHelper.getSpaceProbes()));
        tb.addDataClickListener(new TableDataClickListener<String[]>() {
            @Override
            public void onDataClicked(int rowIndex, String[] clickedData) {
                Toast.makeText(TableDaliyMovmentes.this, ((String[]) clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //  tb.setDataAdapter(new SimpleTableDataAdapter(this,tableHelper.getSpaceProbes()));

     /*  itemsDaily = dbHelper.getAllDailyMovementsBySearch(newText);
        if (itemsDaily !=null){
           tableHelper.setFilter(itemsDaily);
        }*/


        return false;
    }
}
