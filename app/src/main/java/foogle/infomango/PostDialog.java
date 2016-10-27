package foogle.infomango;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class PostDialog extends DialogFragment {

    EditText title;
    EditText msg;
    String resultTitle;
    String msgBody;
    onCompleteListener onCompleteResult;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.submit_dialog, null);


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view);
                // Add action buttons

                builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        title =(EditText) view.findViewById(R.id.title);
                        msg = (EditText) view.findViewById(R.id.message);
                        resultTitle = title.getText().toString();
                        msgBody = msg.getText().toString();

                        onCompleteResult.onComplete(resultTitle, msgBody);
                        Toast.makeText(getActivity().getApplicationContext(), "Post Created", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        PostDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public void setDialogResult(onCompleteListener dialogResult){
        onCompleteResult = dialogResult;
    }
}
