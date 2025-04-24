package com.review.adapter.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offer")
public class OfferCommandController {


    @GetMapping("/list")
    public String getOfferList() {
        return "offer list";
    }

}
