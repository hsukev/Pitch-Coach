package design.com.pitchcoach.utility;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import design.com.pitchcoach.baseClasses.BaseQuestion;
import design.com.pitchcoach.quizTypes.pitch.PitchQuestion;

/**
 * Created by jerye on 3/21/2018.
 */

public class QuestionsGenerator {
    private Context mContext;

    /**
     * @param context TODO: Grab user preferences from context i.e difficulty level, # of questions, types of question
     */
    public QuestionsGenerator(Context context) {
        mContext = context;

    }

    /**
     * @return List<BaseQuestion> could be any <T extends BaseQuestion>
     * TODO: Fill in algorithm to generate questions based on preferences
     */
    public List<BaseQuestion> generateQuestions(int num, BaseQuestion.QuestionType... types) {
        List<BaseQuestion> questions = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            questions.add(newQuestion(types));
        }

        return questions;
    }

    private BaseQuestion newQuestion(BaseQuestion.QuestionType... types) {
//        BaseQuestion question;
//
//        if (types.length == 1) {
//            question =  ne
//            switch (types[0]) {
//                case PITCH:
//                    question = new PitchQuestion();
//                    break;
//                case NOTE:
//                    // same thing for note fragment
//                    break;
//                default:
//                    question = new PitchQuestion();
//                    throw new RuntimeException("Unable to generate question. QuestionType does not exist");
//            }
//        } else {
//            question = new PitchQuestion();
//        }
        return new PitchQuestion();
    }
}
