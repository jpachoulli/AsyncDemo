package com.ebookfrenzy.asyncdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.AsyncTask;

public class AsyncDemoActivity extends AppCompatActivity {

    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_demo);

        myTextView = findViewById(R.id.myTextView);
    }

    public void buttonClick(View view) {
        AsyncTask myTask = new MyTask().execute();
    }

    private class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... params) {
            int i = 0;

            while(i <= 20) {
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                    i++;
                } catch (Exception e) {
                    return(e.getLocalizedMessage());
                }
            }
            return "Button Pressed";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            myTextView.setText("Counter = " + values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            myTextView.setText("Button Pressed");
        }
    }

}
