package design.com.pitchcoach.baseClasses;

import java.util.Collection;

/**
 * QuestionType
 * 1 = Pitch
 * 2 = Note
 * 3 = ...
 */

public interface BaseQuestion<Q, A> {
    Q getQuestion();
    A getAnswer();
    Collection<A> getChoices();
    QuestionType getQuestionType();

    enum QuestionType{
        PITCH,
        NOTE
    }
}
