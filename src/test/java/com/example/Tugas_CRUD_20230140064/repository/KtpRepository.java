package com.example.Tugas_CRUD_20230140064.repository;

import com.example.Tugas_CRUD_20230140064.entity.ktp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KtpRepository extends JpaRepository<ktp, Integer> {

    Optional<ktp> findByNomorKtp(String nomorKtp);

}
