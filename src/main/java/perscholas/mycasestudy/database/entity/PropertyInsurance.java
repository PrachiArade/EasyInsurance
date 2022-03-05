package perscholas.mycasestudy.database.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "propertyinsurance")
public class PropertyInsurance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "insurancepropertyname")
    private String insurancePropertyName;

}
