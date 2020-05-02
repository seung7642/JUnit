package application;

import application.domain.Answer;
import application.domain.BooleanQuestion;
import application.domain.Criterion;
import application.domain.Question;
import application.domain.type.Bool;
import application.domain.type.Weight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.02
 * Time : 23:25
 */
public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create() {
        profile = new Profile("Pangtrue. Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);

        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        criteria.add(new Criterion(criteriaAnswer, Weight.MustMatch));

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);

        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        criteria.add(new Criterion(criteriaAnswer, Weight.DontCare));

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }
}
