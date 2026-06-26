package com.kodegravity.inclass_exr.Service;

import com.kodegravity.inclass_exr.dto.RestfulapidevObjectDTO;
import com.kodegravity.inclass_exr.feignClients.RestfulApiDevFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestfulapidevImpl implements IRestfulapidev {

//    @Autowired
    final RestfulApiDevFeignClient restfulApiDevFeignClient;

    @Override
    public List<RestfulapidevObjectDTO> restfulapiGetCollections() {
        return restfulApiDevFeignClient.restfulapiGetCollections();
    }

    @Override
    public RestfulapidevObjectDTO restfulapiGetObject(String id) {
        RestfulapidevObjectDTO restfulapidevObjectDTO = restfulApiDevFeignClient.restfulapiGetObject(id);
        return restfulapidevObjectDTO;
    }

    @Override
    public RestfulapidevObjectDTO restfulapiAddObject(RestfulapidevObjectDTO restObj) {
        RestfulapidevObjectDTO restfulapidevObjectDTO = restfulApiDevFeignClient.restfulapiAddObject(restObj);
        return restfulapidevObjectDTO;
    }

    @Override
    public RestfulapidevObjectDTO restfulapiPutObject(RestfulapidevObjectDTO restObj) {
        RestfulapidevObjectDTO restfulapidevObjectDTO = restfulApiDevFeignClient.restfulapiPutObject(restObj, restObj.getId());
        return restfulapidevObjectDTO;
    }

    @Override
    public RestfulapidevObjectDTO restfulapiPatchObject(RestfulapidevObjectDTO restObj) {
        try {
            RestfulapidevObjectDTO restfulapidevObjectDTO = restfulApiDevFeignClient.restfulapiPatchObject(restObj, restObj.getId());
            return restfulapidevObjectDTO;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String restfulapiDeleteObject(String id) {
        return restfulApiDevFeignClient.restfulapiDeleteObject(id);
    }

}
