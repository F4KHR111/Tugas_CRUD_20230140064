package com.example.Tugas_CRUD_20230140064.service;

import com.example.Tugas_CRUD_20230140064.dto.KtpDto;
import java.util.List;

public interface KtpService {

    KtpDto create(KtpDto dto);
    List<KtpDto> getAll();
    KtpDto getById(Integer id);
    KtpDto update(Integer id, KtpDto dto);
    void delete(Integer id);
}
