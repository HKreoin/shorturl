package org.kreoin.shorturl.service;

import org.kreoin.shorturl.dto.UrlCreateDTO;
import org.kreoin.shorturl.entity.Url;
import org.kreoin.shorturl.exception.ResourceNotFoundException;
import org.kreoin.shorturl.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.kreoin.shorturl.util.UrlUtil.generateToken;

@Service
public class UrlService {
    @Autowired
    private UrlRepository repository;


    public List<Url> getAll() {
        var urls = repository.findAll();
        return urls;
    }

    public Url findByShortUrl(String slug) {
        var url = repository
                .findByShortUrlToken(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Короткая ссылка "
                        + slug + " не найдена в базе данных"));
        var urlDto = new Url();
        url.plusCount();
        repository.save(url);
        urlDto.setId(url.getId());
        urlDto.setLongUrl(url.getLongUrl());
        urlDto.setShortUrlToken(url.getShortUrlToken());
        urlDto.setRequestCount(url.getRequestCount());
        return urlDto;
    }

    public Url create(UrlCreateDTO urlData) {
        String token = urlData.getShortUrlToken();

        while (token == null || repository.findByShortUrlToken(token).isPresent()) {
            token = generateToken();
        }

        var url = new Url();
        url.setLongUrl(urlData.getLongUrl());
        url.setShortUrlToken(token);
        url.setRequestCount(0L);

        repository.save(url);
        return url;
    }

    public void delete(String slug) {
        repository.deleteByShortUrlToken(slug);
    }
}
