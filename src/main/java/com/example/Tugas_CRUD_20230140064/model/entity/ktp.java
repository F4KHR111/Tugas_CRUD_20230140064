package com.example.Tugas_CRUD_20230140064.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "ktp")
@Data
public class ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nomorKtp;

    private String namaLengkap;

    private String alamat;

    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;

    private String jenisKelamin;
}
