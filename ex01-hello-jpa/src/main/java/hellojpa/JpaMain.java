package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
/* 회원 등록
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
*/

/* 회원 조회 */
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA"); //수정

            


//            em.persist(member);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}