package application.domain;

public class BooleanQuestion extends Question {

    public BooleanQuestion(int id, String text) {
        super(id, text, new String[] {"NO", "YES"});
    }

    @Override
    public boolean match(int expected, int actual) {
        return expected == actual;
    }
}
