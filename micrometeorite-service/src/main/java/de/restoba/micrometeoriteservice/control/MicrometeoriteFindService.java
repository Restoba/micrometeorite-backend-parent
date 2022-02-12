package de.restoba.micrometeoriteservice.control;

import de.restoba.micrometeoritemodel.generated.rest.model.ImageResult;
import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.micrometeoritemodel.generated.rest.model.PredictionResult;
import de.restoba.micrometeoriteservice.control.mapper.MicrometeoriteFindMapper;
import de.restoba.micrometeoriteservice.entity.ImageEntity;
import de.restoba.micrometeoriteservice.entity.MicrometeoriteFindEntity;
import de.restoba.micrometeoriteservice.entity.repository.ImageRepository;
import de.restoba.micrometeoriteservice.entity.repository.MicrometeoriteFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MicrometeoriteFindService {

    @Autowired
    private MicrometeoriteFindRepository repo;
    @Autowired
    private ImageRepository imageRepo;
    @Autowired
    private MicrometeoriteFindMapper mapper;

    public List<MicrometeoriteFind> getAllMicrometeoriteFinds() {
        return mapper.entitiesToModels(new ArrayList<>(repo.findAll()));
    }

    public MicrometeoriteFind getMicrometeoriteFindById(Integer micrometeoriteFind) {
        return mapper.entityToModel(repo.findById(micrometeoriteFind).get());
    }

    public void deleteMicrometeoriteFind(Integer micrometeoriteFindId) {
        repo.deleteById(micrometeoriteFindId);
    }

    public List<PredictionResult> addMicrometeoriteFind(MicrometeoriteFind body) {
        MicrometeoriteFindEntity entity = mapper.modelToEntity(body);
        repo.save(entity);
        return prediction(entity.getId(), entity.getImages());
    }

    public List<PredictionResult> prediction(Integer id, List<ImageEntity> images){
        List<PredictionResult> predictionResults = new ArrayList<>();
        List<ImageResult> imageResultList = new ArrayList<>();
        PredictionResult predictionResult = new PredictionResult();
        predictionResult.setMicrometeoriteFindId(BigDecimal.valueOf(id));
        for(ImageEntity ientity : images){
            ImageResult imageResult = new ImageResult();
            imageResult.setImageId(BigDecimal.valueOf(ientity.getId()));
            ientity = MicrometeoriteModelApiService.updatePredictionInEntity(ientity);
/*            double randNumber = Math.random();
            double d = randNumber * 100;
            ientity.setPredictionResult((int) d);
            ientity.setPredictionModel("Random");*/
            imageResult.setMicrometeoritePrediction(BigDecimal.valueOf(ientity.getPredictionResult()));
            imageResult.setMicrometeoritePredictionModelName(ientity.getPredictionModel());
            imageResultList.add(imageResult);
            imageRepo.save(ientity);
        }
        predictionResult.setImagesResults(imageResultList);
        predictionResults.add(predictionResult);
        return predictionResults;
    }
}
