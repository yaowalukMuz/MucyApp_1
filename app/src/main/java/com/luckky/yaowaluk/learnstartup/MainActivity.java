package com.luckky.yaowaluk.learnstartup;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvHello;
    EditText etHello;
    Button btnCopy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();

    }

    private void initInstances(){
        tvHello = findViewById(R.id.tvHello);


        tvHello.setMovementMethod(LinkMovementMethod.getInstance());
        tvHello.setText(Html.fromHtml("<b>He<u>ll</u><i>World</i><font color=\"#ff0000\">:: </font><a href=\"http://service.eternity.co.th/mmth\">http://service.eternity.co.th/mmth</a>"));


        etHello = findViewById(R.id.etHello);
        etHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    /// get value for edittext show textview
                    tvHello.setText(etHello.getText());

                    return true;
                }
                return false;
            }
        });

        btnCopy = findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btnCopy){
            tvHello.setText(etHello.getText());
        }
    }
}
