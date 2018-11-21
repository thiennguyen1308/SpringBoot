package com.faber.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
