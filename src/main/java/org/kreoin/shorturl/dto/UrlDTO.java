package org.kreoin.shorturl.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
public class UrlDTO {
    private Long id;
    private String url;
    private String shortUrl;
    private Long requestCount;
    private LocalDate updatedAt;
    private LocalDate createdAt;
}
