package com.example.Tugas_CRUD_20230140064.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ktp")
@Data
public class ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
