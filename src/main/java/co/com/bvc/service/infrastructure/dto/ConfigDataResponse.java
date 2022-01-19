package co.com.bvc.service.infrastructure.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ConfigDataResponse {
    private String pk;
    private String sk;
    private String description;
}
