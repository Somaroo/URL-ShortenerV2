package com.URL.Shortener.URLShortenerV2.controller;


import com.URL.Shortener.URLShortenerV2.model.URLDTO;
import com.URL.Shortener.URLShortenerV2.model.Url;
import com.URL.Shortener.URLShortenerV2.repository.UrlRepository;
import com.URL.Shortener.URLShortenerV2.service.URLServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    @Autowired
    private URLServiceImp urlServiceImp;

    @Autowired
    UrlRepository urlRepository;
/*
    @PostMapping("/url")
    public Url createUrl(@RequestBody URLDTO urldto) {

        if (!urlRepository.existsByUrl(urldto.getUrl())){
        try {
                Url createUrl = urlServiceImp.createUrl(urldto);
                return createUrl;

        }catch (Exception e){
            e.printStackTrace();
        }}

        return null;
    }

 */


        @PostMapping("/url")
    public Url createUrl(@RequestBody URLDTO urldto) {

        try {
            if (!urlRepository.existsByUrl(urldto.getUrl())) {
                Url createUrl = urlServiceImp.createUrl(urldto);
                return createUrl;
            }
            Url updateUrl = urlServiceImp.updateUrl(urldto);
            return updateUrl;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/urlShort/{urlShort}")
    public Url retrieveUrl(@PathVariable String urlShort) {

        try {
            Url url = urlServiceImp.retrieveUrl(urlShort);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}

