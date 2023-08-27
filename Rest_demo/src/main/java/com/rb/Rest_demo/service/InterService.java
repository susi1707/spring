package com.rb.Rest_demo.service;

import com.rb.Rest_demo.model.CloudVendor;

import java.util.List;

public interface InterService {

    public String createCloud(CloudVendor cloudVendor);
    public String updateCloud(CloudVendor cloudVendor);
    public String deleteCloud(long id);
    public CloudVendor getCloudId(Long id);
    public List<CloudVendor> getAllCloud();
}
