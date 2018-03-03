package com.mawindavic.android.questionapp;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mawindavic.android.questionapp.adapter.MyResultAdapter;
import com.mawindavic.android.questionapp.getters_setters.MyResult;
import com.mawindavic.android.questionapp.myClasses.myStringFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        List<MyResult> myResultList = new ArrayList<MyResult>();
        String[] myAnswers = getIntent().getStringArrayExtra("myAnswers");
        TextView score = findViewById(R.id.score);
       //your score
        int myScore = 0;
        int p = 0;
        for (String answer: myStringFactory.answers) {
            boolean right = false;
            if (answer.equalsIgnoreCase(myAnswers[p])){
                myScore ++;
                right = true;
            }
            //adding to list View
            MyResult myResult = new MyResult();
            myResult.setYourAnswer(myAnswers[p]);
            myResult.setYouAreRight(right);
            myResult.setCorrectAnswer(answer);
            myResultList.add(myResult);
            p++;
        }
        //Scored generated msg
        writeMessage(myScore);
         //Score percentage
        String score_string = "You Scored\n"+ (myScore*10)+"%";
        score.setText(score_string);
        //score
        String text = "You got "+myScore+" out of "+myAnswers.length+"\n Answers below";
        TextView textView = findViewById(R.id.text);
        textView.setText(text);
       //answers list
        ListView listView = findViewById(R.id.list_view);
        /*LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.listview_header,listView,false);
        listView.addHeaderView(header,null,false);*/
        MyResultAdapter adapter = new MyResultAdapter(ResultsActivity.this,myResultList);
        listView.setAdapter(adapter);
    }

    /**
     * Writes congratulatory message
     * @param myScore user got
     */
    private void writeMessage(int myScore) {
        TextView textView = findViewById(R.id.message);
        String message;
        if(myScore == 10){
            textView.setTextColor(Color.GREEN);
            message = "Excellent!";
        }else if(myScore > 7 && myScore < 10 ){
            textView.setTextColor(Color.YELLOW);
            message = "Very Good!";
        }else if(myScore > 5 && myScore < 10){
            textView.setTextColor(Color.BLACK);
            message = "Good!";
        }else if(myScore == 5){
            textView.setTextColor(Color.DKGRAY);
            message = "Fair!";
        }else{
            textView.setTextColor(Color.RED);
            message = "Failed!";
        }


        textView.setText(message);

    }


    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(ResultsActivity.this,QuestionActivity.class));
      /*  super.onBackPressed();*/
    }
}
