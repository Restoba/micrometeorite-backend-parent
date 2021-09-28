package de.restoba.terminverwaltungservice.control;

import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.micrometeoritemodel.generated.rest.model.PredictionResult;
import de.restoba.terminverwaltungservice.control.mapper.MicrometeoriteFindMapper;
import de.restoba.terminverwaltungservice.entity.MicrometeoriteFindEntity;
import de.restoba.terminverwaltungservice.entity.repository.MicrometeoriteFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class MicrometeoriteFindService {

    @Autowired
    private MicrometeoriteFindRepository repo;
    @Autowired
    private MicrometeoriteFindMapper mapper;
    @Autowired
    private ScriptService scriptService;

    public List<MicrometeoriteFind> getAllMicrometeoriteFinds() {
        return mapper.entitiesToModels(new ArrayList<>(repo.findAll()));
    }

    public List<PredictionResult> addMicrometeoriteFind(MicrometeoriteFind body) {
        MicrometeoriteFindEntity entity = mapper.modelToEntity(body);
        repo.save(entity);
        //return scriptService.predictImagesThroughNNModel(entity.getImages());
        return null;
    }
}
