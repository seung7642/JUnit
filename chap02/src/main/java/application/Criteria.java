package application;

import application.domain.Criterion;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.02
 * Time : 23:25
 */
@Data
public class Criteria implements Iterable<Criterion> {

    private List<Criterion> criteria = new ArrayList<>();

    public void add(Criterion criterion) {
        criteria.add(criterion);
    }

    @Override
    public Iterator<Criterion> iterator() {
        return criteria.iterator();
    }

    public int aritmeticMean() {
        return 0;
    }

    public double geometricMean(int[] numbers) {
        int totalProduct = Arrays.stream(numbers)
                .reduce(1, (product, number) -> product * number);

        return Math.pow(totalProduct, 1.0 / numbers.length);
    }
}
