package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView quesTextView;
    TextView totalquesTextView;
    Button ansA, ansB, ansC, ansD;
    Button submit;

    int score = 0;

    int totalQuestions = QuesAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalquesTextView = findViewById(R.id.total_ques);
        quesTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        submit = findViewById(R.id.submit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        totalquesTextView.setText("Total Question: " +totalQuestions);

        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestions) {
            finishQuiz();
            return;
        }
        quesTextView.setText(QuesAnswer.question[currentQuestionIndex]);
        ansA.setText(QuesAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuesAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuesAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuesAnswer.choices[currentQuestionIndex][3]);

        selectedAnswer = "";


    }

    private void finishQuiz() {
        String passStatus;
        if (score >= totalQuestions * 0.6) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is" + score + "Out of" + totalQuestions)
                .setPositiveButton("Restart", ((dialog, i) -> restartQuiz()))
                .setCancelable(false)
                .show();


    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.submit) {
            if (!selectedAnswer.isEmpty()) {
                if (selectedAnswer.equals(QuesAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                } else {
                    clickedButton.setBackgroundColor(Color.MAGENTA);
                }
                currentQuestionIndex++;
                loadNewQuestion();
            } else {

            }

        }
        else{
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.YELLOW);
        }
    }
}

