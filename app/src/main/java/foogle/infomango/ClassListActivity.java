package foogle.infomango;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class ClassListActivity extends AppCompatActivity implements View.OnClickListener {

    private Button disconnect;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        mAuth = FirebaseAuth.getInstance();

        Button class1 = (Button) findViewById(R.id.class1);
        Button class2 = (Button) findViewById(R.id.class2);
        Button class3 = (Button) findViewById(R.id.class3);
        Button class4 = (Button) findViewById(R.id.class4);
        Button class5 = (Button) findViewById(R.id.class5);
        Button class6 = (Button) findViewById(R.id.class6);
        Button class7 = (Button) findViewById(R.id.class7);
        Button class8 = (Button) findViewById(R.id.class8);
        Button class9 = (Button) findViewById(R.id.class9);
        Button class10 = (Button) findViewById(R.id.class10);
        Button class11 = (Button) findViewById(R.id.class11);
        Button class12 = (Button) findViewById(R.id.class12);


        class1.setOnClickListener(this);
        class2.setOnClickListener(this);
        class3.setOnClickListener(this);
        class4.setOnClickListener(this);
        class5.setOnClickListener(this);
        class6.setOnClickListener(this);
        class7.setOnClickListener(this);
        class8.setOnClickListener(this);
        class9.setOnClickListener(this);
        class10.setOnClickListener(this);
        class11.setOnClickListener(this);
        class12.setOnClickListener(this);


        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("");


        disconnect = (Button) findViewById(R.id.button);

        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent connectIntent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(connectIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onClick(View v) {
        int id = v.getId();

        Intent i = new Intent(getApplicationContext(), ClassPostListActivity.class);

        switch(id){
            case R.id.class1:
                i.putExtra("class", getString(R.string.INSY2303));
                startActivity(i);
                break;
            case R.id.class2:
                i.putExtra("class", getString(R.string.INSY3300));
                startActivity(i);
                break;
            case R.id.class3:
                i.putExtra("class", getString(R.string.INSY3303));
                startActivity(i);
                break;
            case R.id.class4:
                i.putExtra("class", getString(R.string.INSY3304));
                startActivity(i);
                break;
            case R.id.class5:
                i.putExtra("class", getString(R.string.INSY3305));
                startActivity(i);
                break;
            case R.id.class6:
                i.putExtra("class", getString(R.string.INSY3330));
                startActivity(i);
                break;
            case R.id.class7:
                i.putExtra("class", getString(R.string.INSY4305));
                startActivity(i);
                break;
            case R.id.class8:
                i.putExtra("class", getString(R.string.INSY4306));
                startActivity(i);
                break;
            case R.id.class9:
                i.putExtra("class", getString(R.string.INSY4308));
                startActivity(i);
                break;
            case R.id.class10:
                i.putExtra("class", getString(R.string.INSY4308));
                startActivity(i);
                break;
            case R.id.class11:
                i.putExtra("class", getString(R.string.INSY4315));
                startActivity(i);
                break;
            case R.id.class12:
                i.putExtra("class", getString(R.string.INSY4325));
                startActivity(i);
                break;
        }
    }
}
