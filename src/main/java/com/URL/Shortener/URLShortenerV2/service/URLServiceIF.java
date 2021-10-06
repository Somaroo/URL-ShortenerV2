package com.URL.Shortener.URLShortenerV2.service;

import com.URL.Shortener.URLShortenerV2.model.Url;

public interface URLServiceIF {

    public String getShortUrl(String url);
    public String retrieveUrl(String shortUrl);
    public void deleteShortUrl(Url url);


}
