package com.sample.servicename.resources;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.sample.servicename.conf.JsonProperties;

@Component
public class SampleComponent {

  @Autowired
  private Environment environment;

  @Autowired
  private JsonProperties jsonProperties;

  public SampleComponent() {}

  public void sampleMethod() {
    Optional<Map<String, String>> result =
        jsonProperties.getMyTestIds(environment.getActiveProfiles());
    if (result.isPresent()) {
      System.out.println("Properties loaded! "
          + jsonProperties.getMyTestIds(environment.getActiveProfiles()).get());
    }
  }

}
