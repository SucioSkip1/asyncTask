package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        new MiAsyncTask().execute(100);
    }
    class MiAsyncTask extends AsyncTask< Integer, Integer , String> {

        @Override
        protected String doInBackground(Integer... parameter) {
            int maximo =parameter[0];
            for (int i=1;i<maximo;i++){
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return "Fin";
        }

        @Override
        protected void onProgressUpdate (Integer...progress){
            int contador=progress[0];
            String text= "Contador="+contador;
            tv.setText(text);
            tv.setTextSize(contador);
        }
        @Override
        protected void onPostExecute (String result){
            tv.append("\n"+result);
        }
    }
}