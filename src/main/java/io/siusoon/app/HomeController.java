package io.siusoon.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Dima: This controller serves no real purpose, rather to provide a landing page 
 * and show some values that are also shown on /actuator/info
 */
@RestController
public class HomeController {

    @Value("${info.pom.name}")
    private String name = null;

    @Value("${info.pom.version}")
    private String version = null;

    @Value("${info.pom.description}")
    private String description = null;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Map<String,String>> root() {

        var versionInfo = new HashMap<String, String>();
        versionInfo.put("meta", "values are injected from pom.xml");
        versionInfo.put("application-name", name);
        versionInfo.put("application-version", version);
        versionInfo.put("application-description", description);

        return ResponseEntity.ok(versionInfo);

    }

}
