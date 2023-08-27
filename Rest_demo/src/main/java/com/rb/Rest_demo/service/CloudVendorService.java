package com.rb.Rest_demo.service;

import com.rb.Rest_demo.Exception.CloudVendorException;
import com.rb.Rest_demo.Repo.CloudVendorRepo;
import com.rb.Rest_demo.model.CloudVendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CloudVendorService implements InterService{

   @Autowired
   CloudVendorRepo repo;

    public CloudVendorService(CloudVendorRepo repo) {
        this.repo = repo;
    }

    @Override
    public String createCloud(CloudVendor cloudVendor) {
       repo.save(cloudVendor);
        return "Saved to DB";
    }

    @Override
    public String updateCloud(CloudVendor cloudVendor) {

        repo.save(cloudVendor);

        return "Updated";
    }

    @Override
    public String deleteCloud(long id) {
        repo.deleteById(id);
        return "delete successfully";
    }

    @Override
    public CloudVendor getCloudId(Long id) {
        if (repo.findById(id).isEmpty()){
            throw new CloudVendorException("Not Found");
        }
        return repo.findById(id).get();
    }

    @Override
    public List<CloudVendor> getAllCloud() {
        return repo.findAll();
    }
}
