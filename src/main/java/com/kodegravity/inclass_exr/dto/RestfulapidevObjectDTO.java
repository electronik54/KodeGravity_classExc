package com.kodegravity.inclass_exr.dto;

import lombok.Data;

import java.util.Map;
import java.util.Optional;

@Data
public class RestfulapidevObjectDTO {

    private String id;
    private String name;
    private Optional<Map<String, String>> data;
    private Optional<String> createdAt;

}
