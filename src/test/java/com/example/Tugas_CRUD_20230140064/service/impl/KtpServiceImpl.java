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

        ktp ktp = new ktp();
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        repository.save(ktp);

        dto.setId(ktp.getId());

        return dto;
    }

    @Override
    public List<KtpDto> getAll() {

        return repository.findAll()
                .stream()
                .map(k -> {
                    KtpDto dto = new KtpDto();
                    dto.setId(k.getId());
                    dto.setNomorKtp(k.getNomorKtp());
                    dto.setNamaLengkap(k.getNamaLengkap());
                    dto.setAlamat(k.getAlamat());
                    dto.setTanggalLahir(k.getTanggalLahir());
                    dto.setJenisKelamin(k.getJenisKelamin());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public KtpDto getById(Integer id) {

        ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        KtpDto dto = new KtpDto();

        dto.setId(ktp.getId());
        dto.setNomorKtp(ktp.getNomorKtp());
        dto.setNamaLengkap(ktp.getNamaLengkap());
        dto.setAlamat(ktp.getAlamat());
        dto.setTanggalLahir(ktp.getTanggalLahir());
        dto.setJenisKelamin(ktp.getJenisKelamin());

        return dto;
    }

    @Override
    public KtpDto update(Integer id, KtpDto dto) {

        ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        repository.save(ktp);

        return dto;
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);

    }
}
