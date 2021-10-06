package com.URL.Shortener.URLShortenerV2.repository;

import com.URL.Shortener.URLShortenerV2.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

}
