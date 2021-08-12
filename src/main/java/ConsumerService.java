import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsumerService {


    public void boughtGoods(String consumer) {
        Session session = HibSessionFactory.getSessionFactory().openSession();
        Transaction r = session.beginTransaction();

        Criteria c = session.createCriteria(Consumer.class);
        c.add(Restrictions.eq("name", consumer));
        Consumer c1 = (Consumer) c.uniqueResult();

        System.out.println("The following goods was bought by " + consumer + ": " + c1.getGoodsInfo());

        r.commit();
        session.close();


    }

    public void findPersonsByProductTitle(String good) {
        Session session = HibSessionFactory.getSessionFactory().openSession();
        Transaction r = session.beginTransaction();

        Criteria c2 = session.createCriteria(Good.class);
        c2.add(Restrictions.eq("name", good));
        Good g1 = (Good) c2.uniqueResult();
        String result = g1.getGoodsInfo().stream()
                .map(c -> c.getConsumer().getName())
                .distinct()
                .collect(Collectors.joining(", ", "The following people bought " + good + ": ", "."));

        System.out.println(result);

        r.commit();
        session.close();

    }

    public void buy_a_Good() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter consumer's name and good name");

        if (scanner.hasNext() & scanner.hasNext()) {
            String consumer = scanner.next();
            String good = scanner.next();
            Session session = HibSessionFactory.getSessionFactory().openSession();
            Transaction r = session.beginTransaction();

            Criteria c = session.createCriteria(Consumer.class);
            c.add(Restrictions.eq("name", consumer));
            Consumer c1 = (Consumer) c.uniqueResult();
            Criteria c2 = session.createCriteria(Good.class);
            c2.add(Restrictions.eq("name", good));
            Good g1 = (Good) c2.uniqueResult();

            GoodsInfo gof1 = new GoodsInfo();
            gof1.setConsumer(c1);
            gof1.setGood(g1);
            gof1.setPrice(g1.getPrice());

            c1.getGoodsInfo().add(gof1);

            r.commit();
            session.close();
        }
    }

    public void deleteConsumer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of consumer wish you delete from base");
        if (scanner.hasNext()) {
            String name = scanner.next();
            Session session = HibSessionFactory.getSessionFactory().openSession();
            Transaction r = session.beginTransaction();

            Criteria c = session.createCriteria(Consumer.class);
            c.add(Restrictions.eq("name", name));
            Consumer c1 = (Consumer) c.uniqueResult();

            session.delete(c1);
            System.out.println(name + " was deleted successfully");

            r.commit();
            session.close();
        }
    }

    public void deleteGood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of good wish you delete from base");
        if (scanner.hasNext()) {
            String good = scanner.next();
            Session session = HibSessionFactory.getSessionFactory().openSession();
            Transaction r = session.beginTransaction();

            Criteria c2 = session.createCriteria(Good.class);
            c2.add(Restrictions.eq("name", good));
            Good g1 = (Good) c2.uniqueResult();

            session.delete(g1);
            System.out.println(good + " was deleted successfully");

            r.commit();
            session.close();
        }

    }
}
