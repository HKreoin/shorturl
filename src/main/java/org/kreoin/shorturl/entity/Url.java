package org.kreoin.shorturl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "url")
public class Url {
    private Long id;
    private String url;
    private String shortUrl;
}
