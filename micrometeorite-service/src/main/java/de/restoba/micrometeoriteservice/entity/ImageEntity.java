package de.restoba.micrometeoriteservice.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime photographyDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_referenzperson_id")
    @ToString.Exclude
    private PersonEntity photographer;
    private String recordingInstrument;
    private String magnification;
    private String camera;
    private String lens;

    @Lob
    @Column(name = "MICROMETEORITE_IMAGE")
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] MicrometeoriteImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPhotographyDate() {
        return photographyDate;
    }

    public void setPhotographyDate(LocalDateTime photographyDate) {
        this.photographyDate = photographyDate;
    }

    public PersonEntity getPhotographer() {
        return photographer;
    }

    public void setPhotographer(PersonEntity photographer) {
        this.photographer = photographer;
    }

    public String getRecordingInstrument() {
        return recordingInstrument;
    }

    public void setRecordingInstrument(String recordingInstrument) {
        this.recordingInstrument = recordingInstrument;
    }

    public String getMagnification() {
        return magnification;
    }

    public void setMagnification(String magnification) {
        this.magnification = magnification;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public byte[] getMicrometeoriteImage() {
        return MicrometeoriteImage;
    }

    public void setMicrometeoriteImage(byte[] micrometeoriteImage) {
        MicrometeoriteImage = micrometeoriteImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ImageEntity that = (ImageEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}