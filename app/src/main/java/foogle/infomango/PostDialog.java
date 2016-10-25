package foogle.infomango;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class PostDialog extends DialogFragment {

    public Dialog onCreateDialog(Bundle b) {

        AlertDialog.Builder dialogB = new AlertDialog.Builder(getActivity());
        dialogB.setTitle("Write Post");
        dialogB.setNegativeButton("Cancel", negativeClick);
        dialogB.setPositiveButton("Submit", positiveClick);

        Dialog d = dialogB.create();
        return d;
    }

    DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface d, int i){

        }
    };

    DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface d, int i){

        }
    };
}
