package com.kodegravity.inclass_exr.Service;

import com.kodegravity.inclass_exr.dto.RestfulapidevObjectDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IRestfulapidev {
    List<RestfulapidevObjectDTO> restfulapiGetCollections();
    RestfulapidevObjectDTO restfulapiGetObject(@PathVariable String id);
    RestfulapidevObjectDTO restfulapiAddObject(@RequestBody RestfulapidevObjectDTO restfulapidevObjectDTO);
    RestfulapidevObjectDTO restfulapiPutObject(@RequestBody RestfulapidevObjectDTO restfulapidevObjectDTO);
    RestfulapidevObjectDTO restfulapiPatchObject(@RequestBody RestfulapidevObjectDTO restfulapidevObjectDTO);
    String restfulapiDeleteObject(@PathVariable String id);
}
