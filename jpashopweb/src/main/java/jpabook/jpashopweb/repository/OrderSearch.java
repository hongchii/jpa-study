package jpabook.jpashopweb.repository;

import jpabook.jpashopweb.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

        private String memberName;
        private OrderStatus orderStatus;
}
