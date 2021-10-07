package com.URL.Shortener.URLShortenerV2.service;

import com.URL.Shortener.URLShortenerV2.model.URLDTO;
import com.URL.Shortener.URLShortenerV2.model.Url;

public interface URLServiceIF {

    public Url createUrl(URLDTO urldto);
    public Url updateUrl(URLDTO urldto);
    public Url persistUrl(Url url);
    public Url retrieveUrl(String urlShort);
    public void deleteUrlShort(Url url);


}
