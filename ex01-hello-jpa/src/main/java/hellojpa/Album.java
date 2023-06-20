package hellojpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") //Dtype(Item.java)에 들어가는 이름 변경, defualt는 class명으로 들어간다
public class Album extends Item{

    private String artist;
}
