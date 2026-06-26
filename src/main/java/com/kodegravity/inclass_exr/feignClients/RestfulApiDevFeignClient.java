package com.kodegravity.inclass_exr.feignClients;

import com.kodegravity.inclass_exr.dto.RestfulapidevObjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "restfulapi", url = "https://api.restful-api.dev/objects")
public interface RestfulApiDevFeignClient {

    @GetMapping("")
    List<RestfulapidevObjectDTO> restfulapiGetCollections();

    @GetMapping("/{id}")
    RestfulapidevObjectDTO restfulapiGetObject(@PathVariable String id);

    @PostMapping("")
    RestfulapidevObjectDTO restfulapiAddObject(@RequestBody RestfulapidevObjectDTO restfulapidevObjectDTO);

    @PutMapping("/{id}")
    RestfulapidevObjectDTO restfulapiPutObject(@RequestBody RestfulapidevObjectDTO restfulapidevObjectDTO, @PathVariable String id);

    @PatchMapping("/{id}")
    RestfulapidevObjectDTO restfulapiPatchObject(@RequestBody RestfulapidevObjectDTO restfulapidevObjectDTO, @PathVariable String id);

    @DeleteMapping("/{id}")
    String restfulapiDeleteObject(@PathVariable String id);
}
