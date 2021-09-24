package de.restoba.terminverwaltungservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "micrometeoritefind")
public class MicrometeoriteFindEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime creationDate;

    private LocalDateTime findDate;

    private String findPlace;

    private String placeDescription;

    private Integer gpsDegree;

    private Integer gpsMinute;

    private Integer gpsSecound;

    private Double diameter;

    private String form;

    private Double weight;

    private String chemicalComposition;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_finder_id")
    private PersonEntity finder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recorder_id")
    private PersonEntity recorder;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_image_id")
    private List<ImageEntity> images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getFindDate() {
        return findDate;
    }

    public void setFindDate(LocalDateTime findDate) {
        this.findDate = findDate;
    }

    public String getFindPlace() {
        return findPlace;
    }

    public void setFindPlace(String findPlace) {
        this.findPlace = findPlace;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public Integer getGpsDegree() {
        return gpsDegree;
    }

    public void setGpsDegree(Integer gpsDegree) {
        this.gpsDegree = gpsDegree;
    }

    public Integer getGpsMinute() {
        return gpsMinute;
    }

    public void setGpsMinute(Integer gpsMinute) {
        this.gpsMinute = gpsMinute;
    }

    public Integer getGpsSecound() {
        return gpsSecound;
    }

    public void setGpsSecound(Integer gpsSecound) {
        this.gpsSecound = gpsSecound;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getChemicalComposition() {
        return chemicalComposition;
    }

    public void setChemicalComposition(String chemicalComposition) {
        this.chemicalComposition = chemicalComposition;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PersonEntity getFinder() {
        return finder;
    }

    public void setFinder(PersonEntity finder) {
        this.finder = finder;
    }

    public PersonEntity getRecorder() {
        return recorder;
    }

    public void setRecorder(PersonEntity recorder) {
        this.recorder = recorder;
    }

    public List<ImageEntity> getImage() {
        return images;
    }

    public void setImage(List<ImageEntity> images) {
        this.images = images;
    }
}