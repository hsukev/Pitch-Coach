package android.pitchcoach.quizTypes.pitch;

import android.content.Context;
import android.os.Bundle;
import android.pitchcoach.R;
import android.pitchcoach.baseClasses.QuizBaseFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by jerye on 3/21/2018.
 */

/**
 * Fragment specific to {@link PitchQuestion}.
 * Question: pitch (sound)
 * Answers: note
 *
 * All QuizFragments should extend {@link QuizBaseFragment}
 * to inherit basic methods to communicate with {@link android.pitchcoach.QuizActivity}
 */
public class PitchQuizFragment extends QuizBaseFragment {
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

        return view;
    }

    @Override
    public void onAttach(Context context) {
        question = getQuestion(PitchQuestion.class);
        super.onAttach(context);
    }


    /**
     * TODO: Update UI to show appropriate result views
     */
    @Override
    public void answeredRight() {
        // popup with congratz message?
        submitAnswer(true);
    }

    @Override
    public void answeredWrong() {
        // popup showing correct answer?
        submitAnswer(false);

    }
}
