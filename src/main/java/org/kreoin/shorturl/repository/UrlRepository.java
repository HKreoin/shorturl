package org.kreoin.shorturl.repository;

import org.kreoin.shorturl.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortUrl(String shortUrl);
    void deleteByShortUrl(String shortUrl);
}
