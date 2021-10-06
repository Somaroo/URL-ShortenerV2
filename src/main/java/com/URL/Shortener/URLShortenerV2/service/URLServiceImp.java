package com.URL.Shortener.URLShortenerV2.service;

import com.URL.Shortener.URLShortenerV2.model.Url;
import com.URL.Shortener.URLShortenerV2.repository.UrlRepository;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class URLServiceImp implements URLServiceIF {
    @Autowired
    Url url;



    @Autowired
    UrlRepository urlRepository;

    public Url createUrl(String url) {

        
        LocalDateTime dateTime = LocalDateTime.now();


        return null;
    }


    @Override
    public String getShortUrl(String url) {
        if (!isUrlValid(url)) {
            throw new RuntimeException("URL is invalid " + url);
        }
        return urlHashing(url);
    }

    @Override
    public String retrieveUrl(String shortUrl) {
        return null;
    }

    @Override
    public void deleteShortUrl(Url url) {

    }


    //is Url valid
    private boolean isUrlValid(String url) {

        boolean urlValid;

        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        urlValid = urlValidator.isValid(url);

        return urlValid;
    }

    // Hashing for Url
    private String urlHashing(String url) {

        String urlHash;

        urlHash = Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).toString();

        return urlHash;

    }
}
