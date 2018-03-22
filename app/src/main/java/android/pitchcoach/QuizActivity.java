package android.pitchcoach;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity for holding a quiz session and state
 * Responsible for generating quiz questions, maintaining progress, and switching questions
 */

public class QuizActivity extends AppCompatActivity implements QuizBaseFragment.QuizFragmentListener {
    private List<BaseQuestion> questionList = new ArrayList<>();
    private int currentQuestionIndex = 0;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        QuestionsGenerator generator = new QuestionsGenerator(this);
        questionList = generator.generateQuestions();
    }




    /**
     * Called by QuizFragment to request current question
     * @return BaseQuestion.
     */
    public BaseQuestion getQuestion(){
        return questionList.get(currentQuestionIndex);
    }

    /**
     * Callback from QuizFragment containing result of particular quiz
     * TODO: Apply logic to create next QuizFragment
     */
    @Override
    public void submitAnswer(boolean isCorrectAnswer) {
        currentQuestionIndex++;
        updateProgressBar();
    }

    /**
     * TODO: Update ProgressBar UI
     */
    public void updateProgressBar(){

    }

}
