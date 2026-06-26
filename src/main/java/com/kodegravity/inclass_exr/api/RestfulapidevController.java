package com.kodegravity.inclass_exr.api;

import com.kodegravity.inclass_exr.Service.IRestfulapidev;
import com.kodegravity.inclass_exr.dto.RestfulapidevObjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/restapi")
@RequiredArgsConstructor
public class RestfulapidevController {

    final IRestfulapidev iRestfulapidev;

    @GetMapping(value = "/getall")
    public List<RestfulapidevObjectDTO> getAll() {
        return iRestfulapidev.restfulapiGetCollections();
    }

    @GetMapping(value = "/getById")
    public RestfulapidevObjectDTO getById(@RequestParam String id) {
        RestfulapidevObjectDTO restfulapidevObjectDTO = iRestfulapidev.restfulapiGetObject(id);
        return restfulapidevObjectDTO;
    }

    /*
    REQUEST BODY
    {
      "name": "Apple MacBook Pro 16",
      "data": {
        "year": 2019,
        "price": 1849.99,
        "CPU model": "Intel Core i9",
        "Hard disk size": "1 TB"
      }
    }
     */
    @PostMapping(value = "/AddObj")
    public RestfulapidevObjectDTO AddObj(@RequestBody RestfulapidevObjectDTO restfulObj) {
        RestfulapidevObjectDTO restfulapidevObjectDTO = iRestfulapidev.restfulapiAddObject(restfulObj);
        return restfulapidevObjectDTO;
    }
    /*
    added ids:
        - ff8081819d82fab6019ed260ba402172 > nikhils phone
        - ff8081819d82fab6019ed26515a62179 > nikhils phone 3
        - ff8081819d82fab6019ed29a065e219e > Nikhils phone 4
     */

    @PutMapping(value = "/putUpdate")
    public RestfulapidevObjectDTO putUpdate(@RequestBody RestfulapidevObjectDTO restfulObj) {
        RestfulapidevObjectDTO restfulapidevObjectDTO = iRestfulapidev.restfulapiPutObject(restfulObj);
        return restfulapidevObjectDTO;
    }

    @PatchMapping("/update")
    public RestfulapidevObjectDTO update(@RequestBody RestfulapidevObjectDTO restfulObj) {
        RestfulapidevObjectDTO restfulapidevObjectDTO = iRestfulapidev.restfulapiPatchObject(restfulObj);
        return restfulapidevObjectDTO;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete (@RequestParam String id) {
        String res = iRestfulapidev.restfulapiDeleteObject(id);
        return ResponseEntity.ok(res);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
//        ErrorResponse err = new ErrorResponse(ex.getMessage(), 404);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//    }

}