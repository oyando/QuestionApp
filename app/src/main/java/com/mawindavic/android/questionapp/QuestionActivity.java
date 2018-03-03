package com.mawindavic.android.questionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mawindavic.android.questionapp.myClasses.myStringFactory;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private int count = 0;
    private TextView quiz_No,question;
    private Button answerOne,answerTwo,answerThree;
    private String[] myAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queston);
        myAnswers = new String[10];
        //View initialisation
        quiz_No = findViewById(R.id.question_no);
        question = findViewById(R.id.question);

        //answer one
        answerOne = findViewById(R.id.answer_1);
        answerOne.setOnClickListener(this);

        //answer Two
        answerTwo = findViewById(R.id.answer_2);
        answerTwo.setOnClickListener(this);

        //answer Three
        answerThree = findViewById(R.id.answer_3);
        answerThree.setOnClickListener(this);
        //
        showQuiz(count);


    }

    /**
     * Fetches and show quiz on views
     * @param i number of quiz fetched
     */
    private void showQuiz(int i) {
        String quiz = "Question "+(i+1)+" of "+myStringFactory.questions.length;
        quiz_No.setText(quiz);
        question.setText(myStringFactory.questions[i]);
        answerOne.setText(myStringFactory.choices[i][0]);
        answerTwo.setText(myStringFactory.choices[i][1]);
        answerThree.setText(myStringFactory.choices[i][2]);
    }

    @Override
    public void onClick(View v) {
     if (count< myStringFactory.questions.length)
      getAnswer(v);
    }

    /**
     * Get users answer from pressed button
     * @param v pressed button
     */
    private void getAnswer(View v) {
        Button b = (Button)v;
        myAnswers[count] = b.getText().toString();
        count++;
        if(count < myStringFactory.questions.length) {
            showQuiz(count);
        }else{
            Intent intent = new Intent(QuestionActivity.this,ResultsActivity.class);
            intent.putExtra("myAnswers",myAnswers);
            startActivity(intent);

        }
    }


}
