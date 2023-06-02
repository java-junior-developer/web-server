package ru.itmo.web.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmo.web.server.entity.Cat;
import ru.itmo.web.server.service.CatService;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {
    @Autowired
    private CatService catService;

    @GetMapping
    public List<Cat> all() {
        return catService.allCats();
    }

    @PostMapping
    public Cat update(@RequestBody Cat userRequest) {
        if (!catService.reserve(userRequest)) return null;
        return userRequest;
    }


}
