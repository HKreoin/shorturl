package org.kreoin.shorturl.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "url")
@EntityListeners(AuditingEntityListener.class)
public class Url {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String url;

    private String shortUrl;

    @LastModifiedDate
    private LocalDate updatedAt;

    @CreatedDate
    private LocalDate createdAt;

    private Long requestCount;

    public void plusCount() {
        requestCount += 1;
    }
}
