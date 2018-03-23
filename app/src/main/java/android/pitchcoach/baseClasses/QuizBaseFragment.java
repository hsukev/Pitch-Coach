package android.pitchcoach.baseClasses;

import android.content.Context;
import android.pitchcoach.QuizActivity;
import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuizBaseFragment.QuizFragmentListener} interface
 * to handle interaction events.
 */
public abstract class QuizBaseFragment extends Fragment {

    private QuizFragmentListener mListener;
    private QuizActivity mQuizActivity;
    public QuizBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mQuizActivity = (QuizActivity) getActivity();

        if (context instanceof QuizFragmentListener) {
            mListener = (QuizFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Provides access to question
     * @return BaseQuestion.
     */
    public <T extends BaseQuestion> T getQuestion(Class<T> type){
        return type.cast(mQuizActivity.getQuestion());
    }

    /**
     * Provides method to submit answer to QuizActivity
     * @param isCorrect
     */
    public void submitAnswer(boolean isCorrect){
        mListener.submitAnswer(isCorrect);
    }

    public abstract void answeredRight();
    public abstract void answeredWrong();

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface QuizFragmentListener {
        void submitAnswer(boolean isCorrectAnswer);
    }
}
