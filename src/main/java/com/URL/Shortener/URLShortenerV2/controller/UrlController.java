package com.URL.Shortener.URLShortenerV2.controller;


import com.URL.Shortener.URLShortenerV2.model.Url;
import com.URL.Shortener.URLShortenerV2.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UrlController {

    @Autowired
    UrlRepository urlRepository;

    // Post Http Method
    @PostMapping
    public String urlGetShort(@RequestBody String url) {

        return null;

      }

    // get Http Method
    @GetMapping()
    public String getUrl(@RequestBody String urlShort){
        return null;
    }

    // Delete Http Method
    @DeleteMapping()
    public void deleteUrl(@RequestBody String url){

    }


}

