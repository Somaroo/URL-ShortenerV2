package com.URL.Shortener.URLShortenerV2.service;

import com.URL.Shortener.URLShortenerV2.model.URLDTO;
import com.URL.Shortener.URLShortenerV2.model.Url;

import java.util.List;

public interface URLServiceIF {

    public Url createUrl(URLDTO urldto);
    public List<Url> urlAllObjs();
    public Url updateUrl(URLDTO urldto);
    public Url persistUrl(Url url);
    public Url retrieveUrl(String urlShort);

}
