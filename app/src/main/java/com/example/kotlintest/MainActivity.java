package com.example.kotlintest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {

    LinearLayoutManager linearLayoutManager;
    RecyclerViewAdapter myRecyclerViewAdapter;
    RecyclerView rvAddPassenges;
    ImageView imgAddPassengers;
    EditText edtEnterNamePassenges;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        rvAddPassenges = findViewById(R.id.recyclerViewAddPassengers);
        imgAddPassengers = findViewById(R.id.imgAdd);
        edtEnterNamePassenges = findViewById(R.id.edtEnterNamePassenges);

        initializeRecyclerViewAddPassengers();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                seeList(myRecyclerViewAdapter.getList());


            }
        });

    }

    private void seeList(String list) {

        int a = 5;
    }

    private void initializeRecyclerViewAddPassengers() {
//        linearLayoutManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager = new GridLayoutManager(this, 5);

        myRecyclerViewAdapter = new RecyclerViewAdapter(this);
        myRecyclerViewAdapter.setOnItemClickListener(this);
        rvAddPassenges.setAdapter(myRecyclerViewAdapter);
        rvAddPassenges.setLayoutManager(linearLayoutManager);

        imgAddPassengers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String newName = edtEnterNamePassenges.getText().toString();
                if (!newName.equals("")) {
                    if (myRecyclerViewAdapter.getItemCount() > 1) {
                        myRecyclerViewAdapter.add(0, newName);
                        edtEnterNamePassenges.setText("");
                    } else {
                        myRecyclerViewAdapter.add(0, newName);
                        edtEnterNamePassenges.setText("");
                    }
                }
            }
        });
    }

    @Override
    public void onItemClick(RecyclerViewAdapter.ItemHolder item, int position) {

        myRecyclerViewAdapter.remove(position);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
