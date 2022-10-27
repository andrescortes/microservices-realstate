package com.dev.springbootmicroservice1realstate.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "real_state")
@Entity
public class RealState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)//cant be empty
    private String name;

    @Column(name = "address", length = 500, nullable = false)
    private String address;

    @Column(name = "image", length = 1200, nullable = true)
    private String picture;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "creat_at", nullable = false)
    private LocalDateTime createDate;
}
