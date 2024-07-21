package org.kreoin.shorturl.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class UrlCreateDTO {
    @Column(columnDefinition="TEXT")
    @Pattern(regexp = "^https?://[0-9a-zA-Z.\\-]{0,100}/[0-9A-z?=\\-&:%#_/]{0,1500}")
    private String longUrl;

    @Pattern(regexp = "[0-9a-zA-Z]{0,20}")
    private String shortUrlToken;
}
