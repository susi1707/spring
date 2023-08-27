package com.rb.Rest_demo.controller;


import com.rb.Rest_demo.model.CloudVendor;
import com.rb.Rest_demo.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloud")
public class Controller {
    @Autowired
    CloudVendorService service;

    @GetMapping("{id}")
    public CloudVendor getDetail(@PathVariable("id") long id){
        return service.getCloudId(id);
    }
    @GetMapping
    public List<CloudVendor> getAllDetail(){
        return service.getAllCloud();
    }
    @PostMapping
    public String postDetail(@RequestBody CloudVendor cloudVendor){

        return service.createCloud(cloudVendor);
    }
    @PutMapping
    public String putDetail(@RequestBody CloudVendor cloudVendor){
        service.updateCloud(cloudVendor);
        return "Updated";
    }
    @DeleteMapping("{id}")
    public void putDetail(@PathVariable("id") Long id){
        service.deleteCloud(id);
    }


}
