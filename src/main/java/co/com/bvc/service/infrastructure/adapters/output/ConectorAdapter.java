package co.com.bvc.service.infrastructure.adapters.output;


import co.com.bvc.service.application.ports.output.IConectorPort;
import co.com.bvc.service.infrastructure.dto.ConfifRes;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ConectorAdapter implements IConectorPort {
    RestTemplateBuilder restTemplateBuilder;

    public ConectorAdapter() {
        this.restTemplateBuilder = new RestTemplateBuilder();
    }

    public  List<String> getlistDocType(){
      RestTemplate restTemplate = restTemplateBuilder.build();
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
      String url = "https://api.dev.onboarding.bvc.com.co/db/parameters/TYPEDOC";
        ResponseEntity<ConfifRes> response =
                restTemplate.exchange(url,
                        HttpMethod.GET,
                        request,
                        ConfifRes.class);
        ConfifRes cinf = response.getBody();

      return cinf.getTypeDoc();
  }
}
