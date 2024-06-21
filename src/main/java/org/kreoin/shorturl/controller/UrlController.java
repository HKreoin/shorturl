package org.kreoin.shorturl.controller;

import org.kreoin.shorturl.dto.UrlCreateDTO;
import org.kreoin.shorturl.dto.UrlDTO;
import org.kreoin.shorturl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/urls")
public class UrlController {

    @Autowired
    UrlService service;

    @GetMapping(path = "")
    public List<UrlDTO> index() {
        return service.getAll();
    }

    @GetMapping(path = "{shortUrl}")
    public UrlDTO show(@PathVariable String slug) {
        return service.finsByShortUrl(slug);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public UrlDTO create(@RequestBody UrlCreateDTO urlData) {
        return service.create(urlData);
    }

    @DeleteMapping(path = "{shortUrl}")
    public void delete(@PathVariable String slug) {
        service.delete(slug);
    }
}
