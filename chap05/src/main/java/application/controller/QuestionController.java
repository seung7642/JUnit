package application.controller;

import application.domain.Persistable;
import application.domain.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Clock;
import java.util.List;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.03
 * Time : 16:50
 */
public class QuestionController {

    private Clock clock = Clock.systemUTC();

    private static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("postgres-ds");
    }

    public Question find(Integer id) {
        return em().find(Question.class, id);
    }

    public List<Question> getAll() {
        return em().createQuery("select q from Question q", Question.class).getResultList();
    }

    private int persist(Persistable object) {

    }

    private EntityManager em() {
        return getEntityManagerFactory().createEntityManager();
    }
}
