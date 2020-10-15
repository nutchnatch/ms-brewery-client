package guru.springframework.msscbreweryclient.web.config;

import org.springframework.web.client.RestTemplate;

/**
 * Callback interface that can be used to customize a {@link RestTemplate}
 */
@FunctionalInterface
public interface RestTemplateCustomizer {

    /**
     * Callback to customize a {@link RestTemplate} instance.
     * @param restTemplate
     */
    void customize(RestTemplate restTemplate);
}
