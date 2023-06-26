package jpql;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member m"); //타입정보를 받을 수 없을 때 사용 (반환타입이 명확하지 않을 때)
//            List<Member> resultList = query1.getResultList(); // 결과가 여러개 일때
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//            Member singleResult = query1.getSingleResult(); // 결과가 하나일때
//            System.out.println("result = " + singleResult);

            Member result = em.createQuery("select m.username from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();
            System.out.println("result = " + result.getUsername());

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

    }

}
