package com.eden;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eden.Adapters.StateAdapter;
import com.eden.Models.StateModel;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class StateActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    private RecyclerView mRecyclerView;
    private StateAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    // private StateAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.states_list);
        ArrayList<StateModel> stateItem = new ArrayList<>();

        stateItem.add(new StateModel("Lagos", "Rain Forest"));
        stateItem.add(new StateModel("Bauchi", "Savannah"));
        stateItem.add(new StateModel("Borno", "Savannah"));
        stateItem.add(new StateModel("Kano", "Savannah"));
        stateItem.add(new StateModel("Kwara", "Savannah"));
        stateItem.add(new StateModel("Ogun", "Rain Forest"));
        stateItem.add(new StateModel("Ondo", "Rain Forest"));
        stateItem.add(new StateModel("Oyo", "Rain Forest"));
        stateItem.add(new StateModel("Rivers", "Rain Forest"));
        stateItem.add(new StateModel("Sokoto", "Savannah"));
        stateItem.add(new StateModel("Taraba", "Savannah"));
        stateItem.add(new StateModel("Osun", "Savannah"));
        stateItem.add(new StateModel("Benue", "Tropical Rainforest"));
        stateItem.add(new StateModel("Bauchi", "Savannah"));
        stateItem.add(new StateModel("Kano", "Savannah"));
        stateItem.add(new StateModel("Kwara", "Savannah"));
        stateItem.add(new StateModel("Ogun", "Rainforest"));
        stateItem.add(new StateModel("Rivers", "Fresh Water Swamp"));
        stateItem.add(new StateModel("Enugu", "Savannah"));
        stateItem.add(new StateModel("Kastina", "Savannah"));
        stateItem.add(new StateModel("Kaduna", "Savannah"));
        stateItem.add(new StateModel("plateau", "Savannah"));
        stateItem.add(new StateModel("Kogi", "Savannah"));
        stateItem.add(new StateModel("Abuja", "Savannah"));
        stateItem.add(new StateModel("Edo", "Tropical Rainforest"));
        stateItem.add(new StateModel("Niger", "Savannah"));


        mRecyclerView = findViewById(R.id.state_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new StateAdapter(stateItem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new StateAdapter.OnItemClickedListener() {
            @Override
            public void OnItemClick(int position) {

                final ProgressDialog progressDialog = new ProgressDialog(StateActivity.this);
                progressDialog.setTitle("Loading...");
                progressDialog.show();


                final String state = stateItem.get(position).getStateName().toString();
                Intent intent = new Intent(StateActivity.this, CropsActivity.class);
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("FarmerInput", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("state", state);
                editor.apply();
                startActivity(intent);
               /* Users user =new Users("", s, e);
                FirebaseDatabase.getInstance().getReference("Users").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance()
                        .getCurrentUser())).getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

            progressDialog.dismiss();
            Intent intent= new Intent(StateActivity.this, CropsActivity.class);
            intent.putExtra("sendState",s);
            intent.putExtra("sendForest",f);
            intent.putExtra("sendTendency",e);
            startActivity(intent);

                    }
                });
            }
        }

        );
*/

            }


        });
    }
}

