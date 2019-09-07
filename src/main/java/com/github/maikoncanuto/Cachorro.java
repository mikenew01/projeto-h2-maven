package com.github.maikoncanuto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CACHORRO", schema = "DBANIMAL")
@Data
public class Cachorro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CACHORRO")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

}
