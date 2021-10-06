package com.URL.Shortener.URLShortenerV2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Url {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob
    private String url;
    private String shortUrl;
    private LocalDateTime urlDate;
    private long urlCallNumber;
}
