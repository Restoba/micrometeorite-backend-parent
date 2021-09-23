package de.restoba.terminverwaltungservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "micrometeoritefind")
public class MicrometeoriteFindEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private LocalDateTime Datetime;

    @Lob
    @Column(name="MICROMETEORITE_PHOTO")
    private byte[] MicrometeoritePhoto;

}