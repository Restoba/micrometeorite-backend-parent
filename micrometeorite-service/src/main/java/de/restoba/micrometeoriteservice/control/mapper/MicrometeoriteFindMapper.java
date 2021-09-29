package de.restoba.micrometeoriteservice.control.mapper;

import de.restoba.micrometeoritemodel.generated.rest.model.Image;
import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.micrometeoriteservice.entity.ImageEntity;
import de.restoba.micrometeoriteservice.entity.MicrometeoriteFindEntity;
import de.restoba.micrometeoriteservice.entity.repository.ImageRepository;
import de.restoba.micrometeoriteservice.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MicrometeoriteFindMapper {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private ImageRepository imageRepo;

    @Autowired
    private PersonRepository personRepo;

    public MicrometeoriteFindEntity modelToEntity(MicrometeoriteFind model) {
        MicrometeoriteFindEntity entity = new MicrometeoriteFindEntity();
        List<ImageEntity> imageEntityList = new ArrayList<>();

        for(Image i : model.getImages()){
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setCamera(i.getCamera());
            imageEntity.setLens(i.getLens());
            imageEntity.setMicrometeoriteImage(i.getPicture().getBytes(StandardCharsets.UTF_8));
            imageEntity.setPhotographer(personMapper.modelToEntity(i.getPhotographer()));
            personRepo.save(imageEntity.getPhotographer());
            imageEntity.setPhotographyDate(i.getPhotographyDate());
            imageEntity.setRecordingInstrument(i.getRecordingInstrument());
            imageEntity.setMagnification(i.getMagnification());
            imageEntityList.add(imageEntity);
        }
        imageRepo.saveAll(imageEntityList);
        entity.setFinder(personMapper.modelToEntity(model.getMicrometeoriteFindFinder()));
        personRepo.save(entity.getFinder());
        entity.setRecorder(personMapper.modelToEntity(model.getMicrometeoriteFindRecorder()));
        personRepo.save(entity.getRecorder());
        entity.setCreationDate(LocalDateTime.now());
        // Umwandlung coord in Degree Secounds und Minutes
        int sec = (int)Math.round(model.getMicrometeoriteFindCoordinates() * 3600);
        int deg = sec / 3600;
        sec = Math.abs(sec % 3600);
        int min = sec / 60;
        sec %= 60;
        entity.setGpsDegree(deg);
        entity.setGpsSecound(sec);
        entity.setGpsMinute(min);
        entity.setFindPlace(model.getMicrometeoriteFindPlace());
        entity.setPlaceDescription(model.getMicrometeoriteFindPlaceDescription());
        entity.setChemicalComposition(model.getMicrometeoriteChemicalComposition());
        entity.setComment(model.getMicrometeoriteFindComment());
        entity.setDiameter(model.getMicrometeoriteDiameter());
        entity.setFindDate(model.getMicrometeoriteFindDate());
        entity.setForm(model.getMicrometeoriteForm());
        entity.setImage(imageEntityList);
        return entity;
    }

    public MicrometeoriteFind entityToModel(MicrometeoriteFindEntity entity) {
        MicrometeoriteFind model = new MicrometeoriteFind();
        List<Image> images = new ArrayList<>();
        model.setMicrometeoriteDiameter(entity.getDiameter());
        model.setMicrometeoriteChemicalComposition(entity.getChemicalComposition());
        model.setMicrometeoriteFindComment(entity.getComment());
        model.setMicrometeoriteFindDate(entity.getFindDate());
        model.setMicrometeoriteFindId(BigDecimal.valueOf(entity.getId()));
        model.setMicrometeoriteFindPlace(entity.getFindPlace());
        model.setMicrometeoriteFindPlaceDescription(entity.getPlaceDescription());
        model.setMicrometeoriteFindCoordinates(convertDegreeAngleToDouble(entity.getGpsDegree(),entity.getGpsMinute(),entity.getGpsSecound()));
        model.setMicrometeoriteWeight(entity.getWeight());

        model.setMicrometeoriteFindFinder(personMapper.entityToModel(entity.getFinder()));
        model.setMicrometeoriteFindRecorder(personMapper.entityToModel(entity.getRecorder()));

        for (ImageEntity ientity : entity.getImages()){
            Image image = new Image();
            image.setPicture(new String(ientity.getMicrometeoriteImage()));
            image.setImageId(BigDecimal.valueOf(ientity.getId()));
            image.setCamera(ientity.getCamera());
            image.setLens(ientity.getLens());
            image.setMagnification(ientity.getMagnification());
            image.setPhotographer(personMapper.entityToModel(ientity.getPhotographer()));
            image.setPhotographyDate(ientity.getPhotographyDate());
            image.setRecordingInstrument(ientity.getRecordingInstrument());
            images.add(image);
        }
        model.setImages(images);

        return model;
    }

    public List<MicrometeoriteFindEntity> modelsToEntities(List<MicrometeoriteFind> models) {
        List<MicrometeoriteFindEntity> entities = new ArrayList<>();
        for(MicrometeoriteFind model : models){
            entities.add(modelToEntity(model));
        }
        return entities;
    }

    public List<MicrometeoriteFind> entitiesToModels(List<MicrometeoriteFindEntity> entities) {
        List<MicrometeoriteFind> models = new ArrayList<>();
        for(MicrometeoriteFindEntity entity : entities){
            models.add(entityToModel(entity));
        }
        return models;
    }

    public double convertDegreeAngleToDouble( double degrees, double minutes, double seconds )
    {
        //Decimal degrees =
        //   whole number of degrees,
        //   plus minutes divided by 60,
        //   plus seconds divided by 3600

        return degrees + (minutes/60) + (seconds/3600);
    }

}
