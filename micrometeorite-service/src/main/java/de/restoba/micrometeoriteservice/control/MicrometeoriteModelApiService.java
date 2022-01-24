package de.restoba.micrometeoriteservice.control;

import cn.hutool.json.JSONObject;
import de.restoba.micrometeoriteservice.entity.ImageEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class MicrometeoriteModelApiService {
    public static ImageEntity updatePredictionInEntity(ImageEntity ientity) {
        //Request aufbauen
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("file", new String(ientity.getMicrometeoriteImage()));
        HttpEntity<Object> requestEntity = new HttpEntity<>(body,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://127.0.0.1:5000/predictionMerkelVoigt", HttpMethod.POST, requestEntity, String.class);
        //ientity.setPredictionResult(prediction);
        JSONObject jsonObject = new JSONObject(responseEntity.getBody());
        double d = jsonObject.getDouble("result") * 100;
        ientity.setPredictionResult((int) d);
        ientity.setPredictionModel("MerkelVoigt");
        return ientity;
    }
}
