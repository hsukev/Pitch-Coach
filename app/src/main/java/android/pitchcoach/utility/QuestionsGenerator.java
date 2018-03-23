package android.pitchcoach.utility;

import android.content.Context;
import android.pitchcoach.baseClasses.BaseQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerye on 3/21/2018.
 */

public class QuestionsGenerator {
    private Context mContext;

    /**
     * @param context
     * TODO: Grab user preferences from context i.e difficulty level, # of questions, types of question
     */
    public QuestionsGenerator(Context context){
        mContext = context;

    }

    /**
     * @return List<BaseQuestion> could be any <T extends BaseQuestion>
     * TODO: Fill in algorithm to generate questions based on preferences
     */
    public List<BaseQuestion> generateQuestions(){
        List<BaseQuestion> questions =  new ArrayList<>();
        return questions;
    }
}
