package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Member member1 = new Member();
            member1.setName("member1");
            em.persist(member1);

//            Member member2 = new Member();
//            member2.setName("member2");
//            em.persist(member2);

            em.flush();
            em.clear();

//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.find(Member.class, member2.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());

//            System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass())); //true
//            Member findMember = em.getReference(Member.class, member.getId());

            /*영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference()를 호출해도 실제 엔티티 반환*/
            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); //Proxy
//            refMember.getName(); //강제초기화
            Hibernate.initialize(refMember); //강제초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember)); // 초기화 됐는지 확인

 /*
            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getClass()); //Member

            System.out.println("refMember == findMember: " + (refMember == findMember)); // 결과 True
*/
//            em.detach(refMember); // could not initialize proxy [hellojpa.Member#1] - no Session
//            em.close(); // could not initialize proxy [hellojpa.Member#1] - no Session
//            refMember.getName();

//            refMember.getName();
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

    }

    private static Member saveMember(EntityManager em) {
        Member member = new Member();
        member.setName("member1");

        em.persist(member);
        return member;
    }
}
