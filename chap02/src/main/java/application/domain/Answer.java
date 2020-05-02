package application.domain;

import lombok.Getter;
import lombok.ToString;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.02
 * Time : 23:25
 */
@Getter
@ToString
public class Answer {

    private Question question;
    private int i;

    public Answer(Question question, int i) {
        this.i = i;
        this.question = question;
    }

    public Answer(Question question, String matchingValue) {
        this.question = question;
        this.i = question.indexOf(matchingValue);
    }

    public boolean match(int expected) {
        return question.match(expected, i);
    }

    public boolean match(Answer otherAnswer) {
        return question.match(i, otherAnswer.i);
    }
}
