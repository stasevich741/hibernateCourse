package dmdev.lesson;

import dmdev.Conf;
import dmdev.lesson.entity.Role;
import dmdev.lesson.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) throws SQLException {
        Configuration configuration = Conf.getConfiguration();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction(); // начало транзакции
            User user = User.builder()
                    .username("ivan1@mail.ru")
                    .firstname("ivan")
                    .lastname("ivanov")
                    .birthDate(LocalDate.of(2000, 10, 30))
                    .age(22)
                    .role(Role.ADMIN)
                    .build();

            session.saveOrUpdate(user);
            session.getTransaction().commit(); // закрываем транзакцию
        }
    }


}
