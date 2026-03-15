package com.example.Tugas_CRUD_20230140064.service.impl;

import com.example.Tugas_CRUD_20230140064.dto.KtpDto;
import com.example.Tugas_CRUD_20230140064.entity.ktp;
import com.example.Tugas_CRUD_20230140064.repository.KtpRepository;
import com.example.Tugas_CRUD_20230140064.service.KtpService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    public KtpServiceImpl(KtpRepository repository) {
        this.repository = repository;
    }

    @Override
    public KtpDto create(KtpDto dto) {

        if(repository.findByNomorKtp(dto.getNomorKtp()).isPresent()){
            throw new RuntimeException("Nomor KTP sudah ada");
        }

        Ktp ktp = new Ktp();
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        repository.save(ktp);

        dto.setId(ktp.getId());

        return dto;
    }

}
