package android.pitchcoach.quizTypes.pitch;

import android.pitchcoach.baseClasses.BaseQuestion;

import java.util.Collection;

/**
 * TODO: Types are still tentative.
 * Integer = frequency for sound function?
 * String = answer notes i.e "B", "C", "A-sharp"
 */

public class PitchQuestion implements BaseQuestion<Integer, String> {

    // TODO: Define constructor according to required types
    public PitchQuestion(){

    }

    @Override
    public Integer getQuestion() {
        return null;
    }

    @Override
    public String getAnswwer() {
        return null;
    }

    @Override
    public Collection<String> getChoices() {
        return null;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.PITCH;
    }
}
