package guru.springframework.msscbreweryclient.web.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by jt on 2019-04-23.
 */
@ConfigurationProperties(prefix = "sfg.customer", ignoreUnknownFields = false)
@Component
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewCustomer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, beerDto);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public void updateCustomer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid.toString(), beerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + uuid);
    }
}
