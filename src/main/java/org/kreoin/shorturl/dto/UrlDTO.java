package org.kreoin.shorturl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDTO {
    private Long id;
    private String url;
    private String shortUrl;
}
