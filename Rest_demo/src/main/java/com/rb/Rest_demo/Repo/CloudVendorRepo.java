package com.rb.Rest_demo.Repo;

import com.rb.Rest_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CloudVendorRepo extends JpaRepository<CloudVendor,Long> {

    List<CloudVendor> findByName(String name);
}
