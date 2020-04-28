package application.domain;

import application.domain.Answer;
import lombok.Getter;

@Getter
public abstract class Question {

    private int id;
    private String text;
    private String[] answerChoices;

    public Question(int id, String text, String[] answerChoices) {
        this.id = id;
        this.text = text;
        this.answerChoices = answerChoices;
    }

    public boolean match(Answer answer) {
        return false;
    }

    abstract public boolean match(int expected, int actual);

    public int indexOf(String matchingAnswerChoice) {
        for (int i = 0; i < answerChoices.length; ++i) {
            if (answerChoices[i].equals(matchingAnswerChoice)) {
                return i;
            }
        }
        return -1;
    }
}
