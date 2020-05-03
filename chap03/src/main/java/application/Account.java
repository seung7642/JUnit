package application;

import application.common.exception.InsufficientFundsException;
import lombok.Data;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.03
 * Time : 02:53
 */
@Data
public class Account {

    private int balance;
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public void deposit(int dollars) {
        balance += dollars;
    }

    public void withdraw(int dollars) throws InsufficientFundsException {
        if (balance < dollars) {
            throw new InsufficientFundsException("balance only " + balance);
        }
        balance -= dollars;
    }

    public boolean hasPositiveBalance() {
        return balance > 0;
    }
}
