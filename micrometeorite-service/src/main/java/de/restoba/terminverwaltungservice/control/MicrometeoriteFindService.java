package de.restoba.terminverwaltungservice.control;

import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.terminverwaltungservice.control.mapper.MicrometeoriteFindMapper;
import de.restoba.terminverwaltungservice.entity.MicrometeoriteFindEntity;
import de.restoba.terminverwaltungservice.entity.repository.MicrometeoriteFindRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MicrometeoriteFindService {

    private MicrometeoriteFindRepository repo;
    private MicrometeoriteFindMapper mapper;

    public List<MicrometeoriteFind> getAllVaccinecapacitys() {
        return mapper.entitiesToModels(new ArrayList<>(repo.findAll()));
    }

    public void addMicrometeoriteFind(MultipartFile upfile, String micrometeoriteFind) {
        MicrometeoriteFindEntity entity = new MicrometeoriteFindEntity();
        try {
            entity.setMicrometeoritePhoto(upfile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        entity.setDatetime(LocalDateTime.now());
        repo.save(entity);
    }
}
