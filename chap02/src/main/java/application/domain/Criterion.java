package application.domain;

import application.domain.type.Weight;
import lombok.Data;

@Data
public class Criterion {

    private Answer answer;
    private Weight weight;
    private int score;

    public Criterion(Answer answer, Weight weight) {
        this.weight = weight;
        this.answer = answer;
    }
}
