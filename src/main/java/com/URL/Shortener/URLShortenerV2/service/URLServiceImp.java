package com.URL.Shortener.URLShortenerV2.service;

import com.URL.Shortener.URLShortenerV2.model.URLDTO;
import com.URL.Shortener.URLShortenerV2.model.Url;
import com.URL.Shortener.URLShortenerV2.repository.UrlRepository;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class URLServiceImp implements URLServiceIF {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url createUrl(URLDTO urldto) {

        if(!urldto.getUrl().isEmpty() && isUrlValid(urldto.getUrl())){
            String uhlShort = urlHashing(urldto.getUrl());
            LocalDateTime dateTime = LocalDateTime.now();
            Url url = new Url();
            url.setUrl(urldto.getUrl());
            url.setUrlShort(uhlShort);
            url.setUrlDate(dateTime);
            url.setUrlCallNumber(1);
            Url urltoRep = persistUrl(url);

            if(urltoRep != null){
                return urltoRep;
            }
            return null;
        }
        return null;
    }

    @Override
    public Url updateUrl(URLDTO urldto) {

        Url url = urlRepository.findByUrl(urldto.getUrl());
        long calls = url.getUrlCallNumber();

        url.setUrlDate(LocalDateTime.now());
        url.setUrlCallNumber(calls + 1);
        urlRepository.save(url);
            return url;
    }

    @Override
    public Url persistUrl(Url url) {

        Url urlToRep = urlRepository.save(url);
        return urlToRep;

    }

    @Override
    public Url retrieveUrl(String urlShort) {

        Url url = urlRepository.findByUrlShort(urlShort);
        return url;
    }

    @Override
    public void deleteUrlShort(Url url) {
        urlRepository.delete(url);

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
