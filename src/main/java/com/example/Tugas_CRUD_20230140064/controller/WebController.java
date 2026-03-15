package com.example.Tugas_CRUD_20230140064.controller;

import com.example.Tugas_CRUD_20230140064.model.dto.KtpDto;
import com.example.Tugas_CRUD_20230140064.service.KtpService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final KtpService service;

    public WebController(KtpService service){
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listKtp", service.getAll());
        return "index";
    }

    @PostMapping("/save")
    public String save(KtpDto dto){
        service.create(dto);
        return "redirect:/";
    }
}