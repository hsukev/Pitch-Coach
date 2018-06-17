package design.com.pitchcoach.quizTypes.pitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import design.com.pitchcoach.baseClasses.BaseQuestion;

/**
 * TODO: Types are still tentative.
 * Integer = frequency for sound function?
 * String = answer notes i.e "B", "C", "A-sharp"
 */

public class PitchQuestion implements BaseQuestion<Integer, String> {
    Integer question = 3;
    List<String> choices = new ArrayList<>(3);
    String answer = "2";

    // TODO: Define constructor according to required types
    public PitchQuestion(){
    }

    @Override
    public Integer getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public Collection<String> getChoices() {
        choices.add("c1");
        choices.add("c2");
        choices.add("c3");
        return choices;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.PITCH;
    }
}
