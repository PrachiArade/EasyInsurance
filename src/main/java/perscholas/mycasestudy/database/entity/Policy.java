package perscholas.mycasestudy.database.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="policy")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "policy_name")
    private String policyName;

    @Column(name = "tenure")
    private Integer tenure;

    @Column(name = "price")
    private Double price;

    @Column(name = "category")
    private String category;



}
