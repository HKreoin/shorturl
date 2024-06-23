package org.kreoin.shorturl.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class UrlCreateDTO {
    @NotBlank
    private String longUrl;

    @Pattern(regexp = "[0-9a-zA-Z]{1,20}")
    private String shortUrlToken;
}
