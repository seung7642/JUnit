package application.domain;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.02
 * Time : 23:25
 */
public class PercentileQuestion extends Question {

    public PercentileQuestion(int id, String text, String[] answerChoices) {
        super(id, text, answerChoices);
    }

    @Override
    public boolean match(int expected, int actual) {
        return expected <= actual;
    }
}
