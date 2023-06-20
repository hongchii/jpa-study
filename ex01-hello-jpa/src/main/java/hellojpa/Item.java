package hellojpa;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일테이블 전략
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //구현클래스마다 테이블 전략 @DiscriminatorColumn는 필요없음.
//구현클래스마다 테이블 전략은 쓰면 안됨...!!
//@DiscriminatorColumn //DTYPE 이라는 컬럼이 생겨서 album인지 movie인지, book인지 저장됨. - 단일테이블 전략에선 이 어노테이션이 없어도 DTYPE이 필수로 생성됨.
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
