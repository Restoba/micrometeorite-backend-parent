package de.restoba.terminverwaltungservice.boundary;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.restoba.micrometeoritemodel.generated.rest.model.MicrometeoriteFind;
import de.restoba.micrometeoritemodel.generated.rest.model.PredictionResult;
import de.restoba.micrometeoritemodel.generated.rest.resources.MicrometeoriteFindApi;
import de.restoba.terminverwaltungservice.control.MicrometeoriteFindService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "${client.url}")
@Api(tags = "Vaccinecapacity")
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
    public ResponseEntity<PredictionResult> addMicrometeoriteFind(MultipartFile upfile, String micrometeoriteFind) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        service.addMicrometeoriteFind(upfile,micrometeoriteFind);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<MicrometeoriteFind>> getAllMicrometeoriteFinds() {
        return null;
    }
}
