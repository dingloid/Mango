package foogle.infomango;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class ClassListActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView usernameText;

    FirebaseAuth mAuth;
    Bundle extra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        usernameText = (TextView) findViewById(R.id.username);

        mAuth = FirebaseAuth.getInstance();

        extra = getIntent().getExtras();
        String username = extra.getString("username");
        String welcome = getString(R.string.welcome) +" " + username + ",";

        usernameText.setText(welcome);

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

//        disconnect = (Button) findViewById(R.id.button);
//
//        disconnect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mAuth.signOut();
//                Intent connectIntent = new Intent(getApplicationContext(), SignInActivity.class);
//                startActivity(connectIntent);
//                finish();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v) {
        int id = v.getId();

        Intent i = new Intent(getApplicationContext(), MainActivity.class);

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
