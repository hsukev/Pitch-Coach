package design.com.pitchcoach.quizTypes.pitch;

import android.com.pitchcoach.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import design.com.pitchcoach.QuizActivity;
import design.com.pitchcoach.baseClasses.QuizBaseFragment;

/**
 * Created by jerye on 3/21/2018.
 */

/**
 * Fragment specific to {@link PitchQuestion}.
 * Question: pitch (sound)
 * Answers: note
 *
 * All QuizFragments should extend {@link QuizBaseFragment}
 * to inherit basic methods to communicate with {@link QuizActivity}
 */
public class PitchQuizFragment extends QuizBaseFragment {
    @BindView(R.id.choices_grid)
    GridLayout gridLayout;
    @BindView(R.id.submit_button)
    TextView submitButton;
    private PitchQuestion question;



    public PitchQuizFragment() {
        // Required empty public constructor
    }



    /**
     * TODO: Use elements in {@link PitchQuestion} instance to create quiz components
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pitch_quiz_fragment_layout, container, false);
        ButterKnife.bind(this, view);

        for(String choice: question.getChoices()){
            TextView textView = new TextView(getActivity());
            textView.setText(choice);
            gridLayout.addView(textView);
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitAnswer(true);
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        question = getQuestion(PitchQuestion.class);
    }


    @Override
    public void checkAnswer() {
    }
}
