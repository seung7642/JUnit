package application.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Criterion {

    private Weight weight;
    private Answer answer;
    private int score;

    public Criterion(Weight weight, Answer answer) {
        this.weight = weight;
        this.answer = answer;
    }
}
