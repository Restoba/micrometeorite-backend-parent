package de.restoba.terminverwaltungservice.control.mapper;

import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.terminverwaltungservice.entity.MicrometeoriteFindEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MicrometeoriteFindMapper {
    public MicrometeoriteFindEntity modelToEntity(MicrometeoriteFind model) {
        MicrometeoriteFindEntity entity = null;
        return entity;
    }

    public MicrometeoriteFind entityToModel(MicrometeoriteFindEntity entity) {
        MicrometeoriteFind model = new MicrometeoriteFind();
        model.setMicrometeoriteFindId(BigDecimal.valueOf(entity.getId()));
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
}
