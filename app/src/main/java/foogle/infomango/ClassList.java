package foogle.infomango;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassList extends AppCompatActivity {

    private String mGivenName;
    private Button disconnect;

    // arguments for this activity
    public static final String ARG_GIVEN_NAME = "givenName";
    public static final String ARG_DISPLAY_ID = "displayableId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("");

        TextView mTitleTextView = (TextView) findViewById(R.id.titleTextView);

        mGivenName = getIntent().getStringExtra(ARG_GIVEN_NAME);
        mTitleTextView.append(mGivenName + "!");

        disconnect = (Button) findViewById(R.id.button);

        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthenticationManager.getInstance().disconnect();
                Intent connectIntent = new Intent(getApplicationContext(), MainActivity.class);
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
}
