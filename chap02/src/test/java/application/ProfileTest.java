package application;

import application.domain.Answer;
import application.domain.BooleanQuestion;
import application.domain.Criterion;
import application.domain.Question;
import application.domain.type.Bool;
import application.domain.type.Weight;
import org.junit.Test;

public class ProfileTest {

    @Test
    public void test() {
        Profile profile = new Profile("Pangtrue.");
        Question question = new BooleanQuestion(1, "Got bonuses?");
        Criteria criteria = new Criteria();

        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
        criteria.add(criterion);
    }
}
