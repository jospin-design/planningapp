package com.example.planning;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextInputDialogFragment.DialogListener {

    TextView add, name;
    private List<PlaneItem> planeItems;
    private planeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Get the Recycler View
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        add = findViewById(R.id.add_planning);
        name = findViewById(R.id.names);
        name.setText(getIntent().getStringExtra("name"));

        // Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create the budget items
        planeItems = new ArrayList<>();

        planeItems.add(new PlaneItem("second planning", "Rent", "Housing"));
        planeItems.add(new PlaneItem("third planning", "Electricity", "Utilities"));

        // Create the adapter and set it on the Recycler View
        adapter = new planeAdapter(planeItems);
        recyclerView.setAdapter(adapter);

        add.setOnClickListener(v -> showTextInputDialog());
    }

    private void showTextInputDialog() {
        TextInputDialogFragment.newInstance(this)
                .show(getSupportFragmentManager(), "textInputDialog");
    }

    @Override
    public void onTextEntered(String description, String state) {
        // Add the new budget item to the list and notify the adapter
        planeItems.add(new PlaneItem("he", description, state));
        adapter.notifyDataSetChanged();
    }

    private void deleteItem(int position) {
        planeItems.remove(position);
        adapter.notifyItemRemoved(position);
    }
}