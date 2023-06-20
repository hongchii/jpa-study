package hellojpa;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass //공통적으로 사용할 속성에 사용하면 된다.
public abstract class BaseEntity {
    /* @MappedSuperclass,,
    상속관계 매핑 x , 엔티티 x , 테이블과 매핑 x
    테이블이 생성되는 것이 아닌 자식클래스에 매핑 정보만 제공해준다.
    조회, 검색 불가. 단순히 매핑 정보만 제공하는 클래스임.
    직접 생성해서 사용할 일이 없으므로 추상클래스로 만들어서 사용해라.
    주로 등록일, 수정일, 등록자, 수정자 같은 전체 엔티티에서 공통으로 사용하는 것들에 쓰인다.
    엔티티 클래스는 엔티티나 @MappedSuperclass로 지정한 클래스만 상속가능@!!!
    */
    private String createdBy;
    private LocalDateTime createDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
