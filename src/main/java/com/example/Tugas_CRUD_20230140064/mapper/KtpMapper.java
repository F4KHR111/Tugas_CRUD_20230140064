package com.example.Tugas_CRUD_20230140064.mapper;

import com.example.Tugas_CRUD_20230140064.model.dto.KtpDto;
import com.example.Tugas_CRUD_20230140064.model.entity.ktp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KtpMapper {
    KtpMapper MAPPER = Mappers.getMapper(KtpMapper.class);

    KtpDto toDto(ktp ktp);

    ktp toEntity(KtpDto ktpDto);
}