package org.kreoin.shorturl.controller;

import org.kreoin.shorturl.dto.UrlCreateDTO;
import org.kreoin.shorturl.entity.Url;
import org.kreoin.shorturl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    UrlService service;

    @GetMapping(path = "")
    public List<Url> index() {
        return service.getAll();
    }

    @GetMapping(path = "{shortUrl}")
    public RedirectView redirect(@PathVariable String shortUrl) {
        var redirect = new RedirectView();
        var urlModel = service.findByShortUrl(shortUrl);
        redirect.setUrl(urlModel.getUrl());
        return redirect;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Url create(@RequestBody UrlCreateDTO urlData) {
        return service.create(urlData);
    }

    @DeleteMapping(path = "{shortUrl}")
    public void delete(@PathVariable String slug) {
        service.delete(slug);
    }
}
