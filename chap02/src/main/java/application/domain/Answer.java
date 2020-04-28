package application.domain;

import lombok.Getter;
import lombok.ToString;

/**
 * 질문과 답을 담고 있는 클래스.
 *
 * @Author Seungho Lee
 * @Email seung7642@gmail.com
 * @Date 2020.04.28 23:15
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
}
