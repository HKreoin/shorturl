package org.kreoin.shorturl.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "url")
@NoArgsConstructor
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url", unique = true, nullable = false)
    private String url;
    @Column(name = "short_url", unique = true, nullable = false)
    private String shortUrl;
    @LastModifiedDate
    private LocalDate updatedAt;
    @CreatedDate
    private LocalDate createdAt;
}
