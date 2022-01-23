package de.restoba.micrometeoriteservice.control;

import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.math.BigDecimal;

@Service
public class JythonScriptService {
    public BigDecimal callJythonCript(byte[] micrometeoriteImage) {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            StringWriter output = new StringWriter();
            pyInterp.setOut(output);

            pyInterp.exec("print('Hello Baeldung Readers!!')");
        }
        return null;
    }
}
