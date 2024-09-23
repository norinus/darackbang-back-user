package com.lab.darackbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("api")
public class LoginController {
    @GetMapping("/member/logout")
    public String logout() {
        return "logout";
    }
}
