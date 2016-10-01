package foogle.infomango;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationCancelError;
import com.microsoft.aad.adal.AuthenticationException;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.UserInfo;

import java.net.URI;
import java.util.UUID;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ConnectActivity";

    private Button mConnectButton;
    private Button quit;
    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private ProgressBar mConnectProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        // set up our views
        mConnectButton = (Button) findViewById(R.id.connectButton);
        mConnectProgressBar = (ProgressBar) findViewById(R.id.connectProgressBar);
        mTitleTextView = (TextView) findViewById(R.id.titleTextView);
        mDescriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        quit = (Button) findViewById(R.id.quit);

        // add click listener
        mConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConnectingInProgressUI();
                connect();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void connect() {
        // define the post-auth callback
        AuthenticationCallback<AuthenticationResult> callback =
                new AuthenticationCallback<AuthenticationResult>() {

                    @Override
                    public void onSuccess(AuthenticationResult result) {
                        // get the UserInfo from the auth response
                        UserInfo user = result.getUserInfo();

                        // get the user's given name
                        String givenName = user.getGivenName();

                        // get the user's displayable Id
                        String displayableId = user.getDisplayableId();

                        // start the SendMailActivity
                        Intent toClassList =
                                new Intent(MainActivity.this, ClassList.class);

                        // take the user's info along
                        toClassList.putExtra(ClassList.ARG_GIVEN_NAME, givenName);
                        toClassList.putExtra(ClassList.ARG_DISPLAY_ID, displayableId);

                        // actually start the Activity
                        startActivity(toClassList);

                        resetUIForConnect();
                    }

                    @Override
                    public void onError(Exception exc) {
                        if (userCancelledConnect(exc)) {
                            resetUIForConnect();
                        } else {
                            //showConnectErrorUI();
                            Log.d("help" , "error");
                        }
                    }
                };

        AuthenticationManager mgr = AuthenticationManager.getInstance();
        mgr.setContextActivity(this);
        mgr.connect(callback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AuthenticationManager
                .getInstance()
                .getAuthenticationContext()
                .onActivityResult(requestCode, resultCode, data);
    }

    private static boolean userCancelledConnect(Exception e) {
        return e instanceof AuthenticationCancelError;
    }

    private static boolean hasAzureConfiguration() {
        try {
            UUID.fromString(Constants.CLIENT_ID);
            URI.create(Constants.REDIRECT_URI);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private void resetUIForConnect() {
        mConnectButton.setVisibility(View.VISIBLE);
        mTitleTextView.setVisibility(View.GONE);
        mDescriptionTextView.setVisibility(View.GONE);
        mConnectProgressBar.setVisibility(View.GONE);
    }

    private void showConnectingInProgressUI() {
        mConnectButton.setVisibility(View.GONE);
        mTitleTextView.setVisibility(View.GONE);
        mDescriptionTextView.setVisibility(View.GONE);
        mConnectProgressBar.setVisibility(View.VISIBLE);
    }

//    private void showConnectErrorUI() {
//        mConnectButton.setVisibility(View.VISIBLE);
//        mConnectProgressBar.setVisibility(View.GONE);
//        mTitleTextView.setText(R.string.title_text_error);
//        mTitleTextView.setVisibility(View.VISIBLE);
//        mDescriptionTextView.setText(R.string.connect_text_error);
//        mDescriptionTextView.setVisibility(View.VISIBLE);
//        Toast.makeText(
//                ConnectActivity.this,
//                R.string.connect_toast_text_error,
//                Toast.LENGTH_LONG).show();
//    }
}
