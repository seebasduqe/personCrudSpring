package com.personcrud.personcrud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tbl_first_name")
    private String firstName;

    @Column(name="tbl_last_name")
    private String lastName;

    @Column(name="tbl_telef")
    private Long cellularNo;

}
