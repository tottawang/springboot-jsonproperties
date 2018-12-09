package com.sample.servicename.conf;

import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "custom")
@PropertySource(value = "classpath:configprops.json", factory = JsonPropertySourceFactory.class)
public class JsonProperties {

  private Map<String, Map<String, String>> myTestIds;

  public Map<String, Map<String, String>> getMyTestIds() {
    return myTestIds;
  }

  public void setMyTestIds(Map<String, Map<String, String>> myTestIds) {
    this.myTestIds = myTestIds;
  }

  public Optional<Map<String, String>> getMyTestIds(String[] environments) {
    if (environments == null) {
      return Optional.empty();
    }

    for (String environment : environments) {
      Map<String, String> envTestIds = myTestIds.get(environment);
      if (envTestIds != null && !envTestIds.isEmpty()) {
        return Optional.of(envTestIds);
      }
    }

    return Optional.empty();
  }

}
