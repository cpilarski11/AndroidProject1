package com.example.admin.androidproject1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final TextView prompt1 = (TextView) findViewById(R.id.prompt);
        final TextView prompt2 = (TextView) findViewById(R.id.fromBase);
        final TextView prompt3 = (TextView) findViewById(R.id.toBase);
        final TextView answer = (TextView) findViewById(R.id.answerOut);
        Button enter = (Button) findViewById(R.id.enter);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    hideKeyboard();
                    answer.setBackgroundColor(Color.parseColor(getString(R.string.backgroundColorHex)));
                    answer.setText(Integer.toString(Integer.parseInt(prompt1.getText().toString(),
                            Integer.parseInt(prompt2.getText().toString())), Integer.parseInt(prompt3.getText().toString())));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    hideKeyboard();
                    answer.setBackgroundColor(Color.parseColor(getString(R.string.redColor)));
                    Toast.makeText(getApplicationContext(), "Number Format Exception, Please try using valid numbers", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Check your Integer and Base Input Values", Toast.LENGTH_LONG).show();
                    answer.setText("Error, something went wrong :(");
                }

            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void hideKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }


}
