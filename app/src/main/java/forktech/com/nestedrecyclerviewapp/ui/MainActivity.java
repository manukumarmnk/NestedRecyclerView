package forktech.com.nestedrecyclerviewapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import forktech.com.nestedrecyclerviewapp.R;
import forktech.com.nestedrecyclerviewapp.adapter.NestedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    NestedRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new NestedRecyclerViewAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerRoot);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
