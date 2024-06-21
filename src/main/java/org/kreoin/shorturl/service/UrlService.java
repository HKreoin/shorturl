package org.kreoin.shorturl.service;

import org.kreoin.shorturl.dto.UrlCreateDTO;
import org.kreoin.shorturl.dto.UrlDTO;
import org.kreoin.shorturl.exception.ResourceNotFoundException;
import org.kreoin.shorturl.mapper.UrlMapper;
import org.kreoin.shorturl.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    private UrlRepository repository;

    @Autowired
    private UrlMapper mapper;

    public List<UrlDTO> getAll() {
        var urls = repository.findAll();
        return urls
                .stream()
                .map(mapper::map)
                .toList();
    }

    public UrlDTO finsByShortUrl(String slug) {
        var url = repository
                .findByShortUrl(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Короткая ссылка "
                        + slug + " не найдена в базе данных"));
        return mapper.map(url);
    }

    public UrlDTO create(UrlCreateDTO urlData) {
        var url = mapper.map(urlData);
        repository.save(url);
        return mapper.map(url);
    }

    public void delete(String slug) {
        repository.deleteByShortUrl(slug);
    }
}
