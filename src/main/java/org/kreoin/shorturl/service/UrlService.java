package org.kreoin.shorturl.service;

import org.kreoin.shorturl.dto.UrlCreateDTO;
import org.kreoin.shorturl.dto.UrlDTO;
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

    public UrlDTO findByShortUrl(String slug) {
        var url = repository
                .findByShortUrl(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Короткая ссылка "
                        + slug + " не найдена в базе данных"));
        var urlDto = new UrlDTO();
        url.plusCount();
        repository.save(url);
        urlDto.setId(url.getId());
        urlDto.setUrl(url.getUrl());
        urlDto.setShortUrl(url.getShortUrl());
        urlDto.setRequestCount(url.getRequestCount());
        return urlDto;
    }

    public Url create(UrlCreateDTO urlData) {
        String token = "";
        var exist = false;
        while (!exist) {
            token = generateToken();
            if (repository.findByShortUrl(token).isEmpty()) {
                exist = true;
            }
        }
        var url = new Url();
        url.setUrl(urlData.getUrl());
        url.setShortUrl(token);
        url.setRequestCount(0L);

        repository.save(url);
        return url;
    }

    public void delete(String slug) {
        repository.deleteByShortUrl(slug);
    }
}
