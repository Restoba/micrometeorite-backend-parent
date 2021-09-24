package de.restoba.terminverwaltungservice.control.mapper;

import de.restoba.micrometeoritemodel.generated.rest.model.Person;
import de.restoba.terminverwaltungservice.entity.PersonEntity;
import de.restoba.terminverwaltungservice.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonMapper {

    public PersonEntity modelToEntity(Person model) {
        PersonEntity newPersonEntity = new PersonEntity();
        newPersonEntity.setBirthday(model.getBirthday());
        newPersonEntity.setCountry(model.getCountry());
        newPersonEntity.setEmail(model.getEmail());
        newPersonEntity.setFirstname(model.getFirstname());
        newPersonEntity.setName(model.getName());
        newPersonEntity.setLocation(model.getLocation());
        newPersonEntity.setPhonenumber(model.getPhonenumber());
        newPersonEntity.setStreet(model.getStreet());
        newPersonEntity.setWebsite(model.getWebsite());
        newPersonEntity.setZipcode(model.getZipcode());
        return newPersonEntity;
    }

    public Person entityToModel(PersonEntity entity) {
        Person model = new Person();
        return model;
    }

    public List<PersonEntity> modelsToEntities(List<Person> models) {
        List<PersonEntity> entities = new ArrayList<>();
        for(Person model : models){
            entities.add(modelToEntity(model));
        }
        return entities;
    }

    public List<Person> entitiesToModels(List<PersonEntity> entities) {
        List<Person> models = new ArrayList<>();
        for(PersonEntity entity : entities){
            models.add(entityToModel(entity));
        }
        return models;
    }

}
