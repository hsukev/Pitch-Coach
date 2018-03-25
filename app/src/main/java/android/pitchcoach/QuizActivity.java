package android.pitchcoach;

import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.pitchcoach.baseClasses.BaseQuestion;
import android.pitchcoach.baseClasses.QuizBaseFragment;
import android.pitchcoach.quizTypes.pitch.PitchQuizFragment;
import android.pitchcoach.utility.QuestionsGenerator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity for holding a quiz session and state
 * Responsible for generating quiz questions, maintaining progress, and switching questions
 */

public class QuizActivity extends AppCompatActivity implements QuizBaseFragment.QuizFragmentListener {
    private List<BaseQuestion> questionList = new ArrayList<>();
    private int currentQuestionIndex = 0;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    /**
     *
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.quiz_activity);
        ButterKnife.bind(this);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());


        QuestionsGenerator generator = new QuestionsGenerator(this);
        questionList = generator.generateQuestions();
        initializeUI();
        createQuestionFragment();
    }

    private void initializeUI(){
        progressBar.setMax(questionList.size());
        progressBar.setProgress(0);
    }

    /**
     * Called by {@link QuizBaseFragment} to request current question
     * @return BaseQuestion.
     */
    public BaseQuestion getQuestion() {
        return questionList.get(currentQuestionIndex);
    }


    /**
     * Callback from {@link QuizBaseFragment} after congratz/wrong answer popup is finished
     * TODO: Call function to create next {@link QuizBaseFragment}
     */
    @Override
    public void submitAnswer(boolean isCorrectAnswer) {
        currentQuestionIndex++;
        updateProgressBar();
        createQuestionFragment();
    }

    /**
     * TODO: Update ProgressBar UI. Add custom animations
     */
    public void updateProgressBar() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            progressBar.setProgress(currentQuestionIndex, true);
        }else{
            progressBar.setProgress(currentQuestionIndex);
        }
    }

    /**
     * TODO: Create fragment (question) change animation i.e fade-out/slide-in etc.
     */
    private void createQuestionFragment() {
        BaseQuestion question = questionList.get(currentQuestionIndex);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        switch (question.getQuestionType()) {
            case PITCH:
                transaction.add(R.id.fragment_container, PitchQuizFragment.instantiate(this, "pitch")).commit();
                break;
            case NOTE:
                // same thing for note fragment
                break;
            default:
                Toast.makeText(this, "Unable to initialize fragment. Fragment-Question mismatch", Toast.LENGTH_LONG).show();
                throw new RuntimeException("Unable to initialize fragment. Fragment-Question mismatch");
        }
    }

}
