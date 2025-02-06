package com.example.cst20108;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
    EditText marksInput;
    Button calculateButton;
    TextView gradeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marksInput = findViewById(R.id.marksInput);
        calculateButton = findViewById(R.id.calculateButton);
        gradeOutput = findViewById(R.id.gradeOutput);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        String marksText = marksInput.getText().toString().trim();
        if (marksText.isEmpty()) {
            gradeOutput.setTextColor(Color.BLACK);
            gradeOutput.setText("Please fill the field.");
            return;
        }
        int marks = Integer.parseInt(marksText);

        String grade = calculateGradeForSystem(marks);
        gradeOutput.setText("");
        marksInput.setText("");
        gradeOutput.append( "Your grade is : "+grade );


    }

    private String calculateGradeForSystem(int marks) {
        if (marks >= 75) {
            return "A";
        } else if (marks >= 65) {
            return "B";
        } else if (marks >= 55) {
            return "C";
        } else if (marks >= 35) {
            return "D";
        } else {
            return "E";
        }
    }
}