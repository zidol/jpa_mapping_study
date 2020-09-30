package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")     //self join
    private List<Category> child = new ArrayList<>();

    @ManyToMany                                                 //중간 조인 테이블
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),    //내가 조인 걸어야할 컬럼
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")  //반대 테이블이 조인걸어야할 테이블
    )
    private List<Item> items = new ArrayList<>();
}
