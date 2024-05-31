package com.graphql_demo.graphqldemo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class BaseEntity {


    @CreationTimestamp
    private OffsetDateTime created;
    @CreationTimestamp
    private OffsetDateTime updated;
}
