package de.restoba.micrometeoriteservice.control;

import de.restoba.micrometeoritemodel.generated.rest.model.Image;
import de.restoba.micrometeoritemodel.generated.rest.model.ImageResult;
import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.micrometeoritemodel.generated.rest.model.PredictionResult;
import de.restoba.micrometeoriteservice.control.mapper.MicrometeoriteFindMapper;
import de.restoba.micrometeoriteservice.entity.ImageEntity;
import de.restoba.micrometeoriteservice.entity.MicrometeoriteFindEntity;
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
    private MicrometeoriteFindMapper mapper;

    public List<MicrometeoriteFind> getAllMicrometeoriteFinds() {
        return mapper.entitiesToModels(new ArrayList<>(repo.findAll()));
    }

    public void deleteMicrometeoriteFind(Integer micrometeoriteFindId) {
        repo.deleteById(micrometeoriteFindId);
    }

    public List<PredictionResult> addMicrometeoriteFind(MicrometeoriteFind body) {
        MicrometeoriteFindEntity entity = mapper.modelToEntity(body);
        repo.save(entity);
        List<PredictionResult> predictionResults = new ArrayList<>();
        List<ImageResult> imageResultList = new ArrayList<>();
        PredictionResult predictionResult = new PredictionResult();
        predictionResult.setMicrometeoriteFindId(BigDecimal.valueOf(entity.getId()));
        for(ImageEntity ientity : entity.getImages()){
            ImageResult imageResult = new ImageResult();
            imageResult.setImageId(BigDecimal.valueOf(ientity.getId()));
            imageResult.setMicrometeoritePredictionModelName("ModelA");
            //Create random number 0 - 99
            double randNumber = Math.random();
            double d = randNumber * 100;
            imageResult.setMicrometeoritePrediction(BigDecimal.valueOf(d));
            imageResultList.add(imageResult);
        }
        predictionResult.setImagesResults(imageResultList);
        predictionResults.add(predictionResult);
        return predictionResults;
    }
}
