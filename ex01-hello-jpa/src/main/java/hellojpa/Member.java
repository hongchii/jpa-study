package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY) //지연로딩
    @ManyToOne(fetch = FetchType.EAGER) //즉시로딩 - 실무에선 가급적 사용하지 말 것.
    @JoinColumn //(name = "TEAM_ID", insertable = false, updatable = false) //insertable, updatable 옵션을 넣어주면 읽기전용
    private Team team;

    //@OneToOne // Member -> Locker 1:1
    //@JoinColumn(name = "LOCKER_ID")
    //private Locker locker;

    // 다대다는 실무에서 X 불필요한 데이터가 들어올 수 있다. 단순히 연결만 하고 끝나지 않는다. >> OneToMany , MayToOne (연결테이블을 엔티티로 승격)
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
