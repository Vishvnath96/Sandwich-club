package com.udacity.sandwichclub.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MainViewModel mainViewModel;
    String[] sandwiches;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(getApplication());
        mainBinding.setViewModel(mainViewModel);
        mainBinding.executePendingBindings();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mainViewModel.getSandwiches());

        ListView listView = mainBinding.sandwichesListview;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                launchDetailActivity(position);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sandwiches = getResources().getStringArray(R.array.sandwich_details);
    }

    private void launchDetailActivity(int position) {
        if (sandwiches != null && sandwiches[position] != null) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_POSITION, sandwiches[position]);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
        }

    }
}
