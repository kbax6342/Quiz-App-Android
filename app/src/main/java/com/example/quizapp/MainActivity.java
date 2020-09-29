package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;


    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_chocolate, true),
            new Question(R.string.question_oatmeal, true),
            new Question(R.string.question_cheesecake, true),
            new Question(R.string.question_apple_pie, false),
    };

    private int mCurrentIndex = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is setting the TextView question
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);


        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        int messageResId = R.string.correct_toast;
                        Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();

                    }//end onClick

            }//end

        );//end mTrueButton setOnClickListener

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v)
                                           {
                                               int messageResId = R.string.incorrect_toast;
                                               Toast.makeText(MainActivity.this,
                                                       messageResId, Toast.LENGTH_LONG).show();

                                           }//end onClick


                                       }//end

        );//end mFalseButton setOnClickListener

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;


            }
        });


        updateQuestion();



    }//end onCreate
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }


}////end MainActivity class