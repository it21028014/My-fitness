package com.example.fitness2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity  extends AppCompatActivity {

    //register
    RecyclerView recyclerView;
    MainAdapter sanMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //register recyclerView by type casting
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//to fetch the data from the DB Firebase and show it to recyclerview
        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("exercises"), MainModel.class)
                        .build();


        //mainAdapter code
        sanMainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(sanMainAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sanMainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sanMainAdapter.stopListening();
    }
}