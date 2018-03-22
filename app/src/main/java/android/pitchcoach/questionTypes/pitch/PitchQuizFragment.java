package android.pitchcoach.questionTypes.pitch;

import android.content.Context;
import android.os.Bundle;
import android.pitchcoach.QuizBaseFragment;
import android.pitchcoach.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jerye on 3/21/2018.
 */

/**
 * Fragment specific to type of question
 * A simple {@link Fragment} subclass.
 */
public class PitchQuizFragment extends QuizBaseFragment {


    public PitchQuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pitch_quiz_fragment_layout, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        PitchQuestion question = getQuestion(PitchQuestion.class);
        super.onAttach(context);
    }


    /**
     * TODO: Update UI to show result
     */
    @Override
    public void answeredRight() {
        submitAnswer(true);
    }

    @Override
    public void answeredWrong() {
        submitAnswer(false);

    }
}
