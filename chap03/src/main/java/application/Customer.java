package application;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.03
 * Time : 02:53
 */
@Data
public class Customer {

    private List<Account> accounts = new ArrayList<>();

    public void add(Account account) {
        accounts.add(account);
    }
}
