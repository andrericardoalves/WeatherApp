package com.hackerrank.sample.controller;

import com.hackerrank.sample.dto.StringResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SampleController {

    @GetMapping(value = "/defaultHello")
    public ResponseEntity<StringResponse> defaultHello(@RequestParam(defaultValue = "World!") String message){
        StringResponse stringResponse =   new StringResponse("Hello ".concat(message));
        return ResponseEntity.ok().body(stringResponse);
    }

    @PostMapping("/customHello")
    public ResponseEntity<StringResponse> customHello(@RequestParam String message){

        if(message == null || message.isEmpty()){
            ResponseEntity.badRequest().body(new StringResponse("Param is empty"));
        }
       return ResponseEntity.ok().body(new StringResponse("Custom ".concat(message)));
    }

}
