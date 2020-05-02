package application.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.02
 * Time : 23:25
 */
@Data
public class Person {

    private List<Question> questionList = new ArrayList<>();

    public void add(Question question) {
        questionList.add(question);
    }

    public List<Question> withQuestionList(String questionPattern) {
        return questionList.stream()
                .filter(question -> question.getText().endsWith(questionPattern))
                .collect(Collectors.toList());
    }
}
