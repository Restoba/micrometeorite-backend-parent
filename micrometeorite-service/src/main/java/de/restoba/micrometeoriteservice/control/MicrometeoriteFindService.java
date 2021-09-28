package de.restoba.micrometeoriteservice.control;

import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.micrometeoritemodel.generated.rest.model.PredictionResult;
import de.restoba.micrometeoriteservice.control.mapper.MicrometeoriteFindMapper;
import de.restoba.micrometeoriteservice.entity.MicrometeoriteFindEntity;
import de.restoba.micrometeoriteservice.entity.repository.MicrometeoriteFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
