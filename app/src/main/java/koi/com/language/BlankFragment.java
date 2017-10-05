package koi.com.language;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment extends AlertDialog {


    protected BlankFragment(@NonNull Context context) {
        customise();
        super(context);
    }

    
}
