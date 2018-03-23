package android.pitchcoach.baseClasses;

import java.util.Collection;

/**
 * Created by jerye on 3/20/2018.
 */

public interface BaseQuestion<Q, A> {
    Q getQuestion();
    A getAnswwer();
    Collection<A> getChoices();
}
