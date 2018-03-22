package android.pitchcoach;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerye on 3/21/2018.
 */

public class QuestionsGenerator {
    private Context mContext;


    public QuestionsGenerator(Context context){
        // Used to grab user preferences ie. # of questions, difficulty, variations
        mContext = context;

    }

    /**
     * @return List<BaseQuestion> could be any <T extends BaseQuestion>
     *     TODO: Fill in algorithm to generate questions based on preferences
     */
    public List<BaseQuestion> generateQuestions(){
        List<BaseQuestion> questions =  new ArrayList<>();
        return questions;
    }
}
