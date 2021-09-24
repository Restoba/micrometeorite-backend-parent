package de.restoba.terminverwaltungservice.control;

import de.restoba.micrometeoritemodel.generated.rest.model.PredictionResult;
import de.restoba.terminverwaltungservice.entity.ImageEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScriptService {


    public List<PredictionResult> predictImagesThroughNNModel(List<ImageEntity> images) {
        List<PredictionResult> results = new ArrayList<>();

        try {
            for (ImageEntity entity : images) {
                String pythonPath = "C:/Data/micrometeorite-backend-parent/micrometeorite-service/src/main/resources/pythonscripts/modelA.py";
                ProcessBuilder builder = new ProcessBuilder("python", pythonPath, entity.getMicrometeoriteImage().toString());
                Process process = null;

                process = builder.start();

                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader errorbr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                String lines = null;

                while (true) {
                    try {
                        if ((lines = br.readLine()) != null) {
                            System.out.println("lines " + lines);
                        }
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                while (true) {

                    if ((lines = errorbr.readLine()) != null) {
                        System.out.println("error lines " + lines);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
