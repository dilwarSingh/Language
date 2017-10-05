package koi.com.language;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    TextView text;
    Button button;
    appPrefs mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        mPrefs = new appPrefs(this);
        setLocale(mPrefs.getLanguage());

    }

    public void textClick(View view) {

        LayoutInflater li = LayoutInflater.from(this);
        View dialogView = li.inflate(R.layout.fragment_blank, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        // set title
        alertDialogBuilder.setTitle("Custom Dialog");
        // set custom dialog icon
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher_round);
        // set custom_dialog.xml to alertdialog builder
        alertDialogBuilder.setView(dialogView);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false);
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();


    }


    public void customToast(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void changeLang(View view) {

        String language = mPrefs.getLanguage();
        String lang;
        if (language.equals("hi")) {
            lang = "en";
        } else {
            lang = "hi";
        }

        mPrefs.saveLanguage(lang);

        setLocale(lang);
    }


    public void setLocale(String lang) {


        Toast.makeText(this, lang, Toast.LENGTH_SHORT).show();

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, res.getDisplayMetrics());
        onConfigurationChanged(conf);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // refresh your views here

        text.setText(R.string.hello_world);
        button.setText(R.string.change_language);

        super.onConfigurationChanged(newConfig);
    }

}
