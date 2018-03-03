package com.mawindavic.android.questionapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mawindavic.android.questionapp.R;
import com.mawindavic.android.questionapp.getters_setters.MyResult;

import java.util.List;

/**
 * Created by Mawinda on 28-Feb-18.
 */

public class MyResultAdapter extends ArrayAdapter<MyResult> {
    private Context context;
    private List<MyResult> myResultList;

    /**
     * Constructor
     *
     * @param context  The current context.

     * @param objects  The objects to represent in the ListView.
     */
    public MyResultAdapter(@NonNull Context context, @NonNull List<MyResult> objects) {
        super(context, R.layout.listview_body, objects);
        this.context = context;
        this.myResultList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View resultView = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            assert inflater != null;
            resultView = inflater.inflate(R.layout.listview_body, parent, false);
        }

        //initialising Views
        TextView number,yourAnswer,mark,correctAnswer;
        number = resultView.findViewById(R.id.number);
        yourAnswer = resultView.findViewById(R.id.your_answer);
        mark = resultView.findViewById(R.id.mark);
        correctAnswer = resultView.findViewById(R.id.correct_answer);

        MyResult result = myResultList.get(position);
        String numb = String.valueOf(position +1);
        number.setText(numb);
        yourAnswer.setText(result.getYourAnswer());
        correctAnswer.setText(result.getCorrectAnswer());
        if(result.getYourAnswer().equalsIgnoreCase(result.getCorrectAnswer())){
            mark.setText("  √");
            mark.setTextColor(Color.GREEN);
        }else{
            mark.setText("  ×");
            mark.setTextColor(Color.RED);
        }
        return resultView;
    }
}
