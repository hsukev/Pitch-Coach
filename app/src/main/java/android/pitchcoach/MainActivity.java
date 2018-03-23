package android.pitchcoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    /**
     * MainActivity that serves as menu to select type of quizzes
     * UI will also have a setting to define user preferences
     *
     * TODO: Create static UI for finite quiz modes ie. timed quiz, limited tries, practice mode etc.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * TODO: Attach extra to intent depending on mode
     */
    private void startQuiz(){
        Intent quizIntent = new Intent(this, QuizActivity.class);
        // put extra
        startActivity(quizIntent);

    }

}
