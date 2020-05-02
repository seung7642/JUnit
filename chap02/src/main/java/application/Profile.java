package application;

import application.domain.Answer;
import application.domain.Criterion;
import application.domain.type.Weight;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.02
 * Time : 23:25
 */
@Data
public class Profile {

    private Map<String, Answer> answers = new HashMap<>();
    private int score;
    private String name;

    public Profile(String name) {
        this.name = name;
    }

    public void add(Answer answer) {
        answers.put(answer.getQuestion().getText(), answer);
    }

    public boolean matches(Criteria criteria) {
        score = 0;

        boolean kill = false;
        boolean anyMatches = false;

        for (Criterion criterion : criteria) {
            Answer answer = answers.get(criterion.getAnswer().getQuestion().getText());
            boolean match = criterion.getWeight() == Weight.DontCare || answer.match(criterion.getAnswer());

            if (!match && criterion.getWeight() == Weight.MustMatch) {
                kill = true;
            }

            if (match) {
                score += criterion.getWeight().getValue();
            }
            anyMatches |= match;
        }

        if (kill) {
            return false;
        }

        return anyMatches;
    }
}
