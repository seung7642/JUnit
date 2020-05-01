package application;

import application.domain.Answer;
import application.domain.Criterion;
import application.domain.type.Weight;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
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

        // 이 코드가 왜 먹히지?
        // criteria 객체 안에 필드를 굳이 가져오지 않아도, 알아서 판단하는건가?
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
