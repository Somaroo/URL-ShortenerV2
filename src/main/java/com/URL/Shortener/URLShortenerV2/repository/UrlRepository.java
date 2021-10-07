package com.URL.Shortener.URLShortenerV2.repository;

import com.URL.Shortener.URLShortenerV2.model.URLDTO;
import com.URL.Shortener.URLShortenerV2.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    public Url findByUrlShort(@Param("urlShort") String urlShort);
    public Url findByUrl(@Param("url") String url);
    public boolean existsByUrl(@Param("url") String url);

}
