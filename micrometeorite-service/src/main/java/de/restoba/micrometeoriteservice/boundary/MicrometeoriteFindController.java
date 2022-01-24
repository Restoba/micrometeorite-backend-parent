package de.restoba.micrometeoriteservice.boundary;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.micrometeoritemodel.generated.rest.model.PredictionResult;
import de.restoba.micrometeoritemodel.generated.rest.resources.MicrometeoriteFindApi;
import de.restoba.micrometeoriteservice.control.MicrometeoriteFindService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "${client.url}")
@Api(tags = "micrometeoriteFind")
public class MicrometeoriteFindController implements MicrometeoriteFindApi {

    @Autowired
    private MicrometeoriteFindService service;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<List<PredictionResult>> addMicrometeoriteFind(MicrometeoriteFind body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(service.addMicrometeoriteFind(body), headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteMicrometeoriteFind(Integer micrometeoriteFindId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        service.deleteMicrometeoriteFind(micrometeoriteFindId);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MicrometeoriteFind>> getAllMicrometeoriteFinds() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(service.getAllMicrometeoriteFinds(), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MicrometeoriteFind> getMicrometeoriteFindById(Integer micrometeoriteFindId) {
        return null;
    }

}
