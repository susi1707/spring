package com.rb.Rest_demo.repoistory;

import com.rb.Rest_demo.Repo.CloudVendorRepo;
import com.rb.Rest_demo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class cloudVendorRepoTest {

    @Autowired
    private CloudVendorRepo repo;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
         cloudVendor = new CloudVendor(1L,"susi2",6565654L);
        repo.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        repo.deleteAll();

    }
    @Test
    void TestingCloudvendor(){
        List<CloudVendor> cloudVendorList =  repo.findByName("susi2");
        assertThat(cloudVendorList.get(0).getId()).isEqualTo(cloudVendor.getId());
    }
    //failure
    @Test
    void TestingNotFoundCloudVendor(){
        List<CloudVendor> cloudVendorList =  repo.findByName("rb");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }
}
