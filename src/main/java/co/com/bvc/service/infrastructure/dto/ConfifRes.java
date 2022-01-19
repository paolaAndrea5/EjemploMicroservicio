package co.com.bvc.service.infrastructure.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ConfifRes {
    private String message;
    private List<ConfigDataResponse> data;
    private String error;

    public String printable(){
        try{
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Unserializable data";
        }
    }

    public List<String> getTypeDoc(){
        return  data.stream().map(list -> list.getSk()).collect(Collectors.toList());
    }
}