package com.rb.Rest_demo.service;

import com.rb.Rest_demo.Repo.CloudVendorRepo;
import com.rb.Rest_demo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CloudVendorServiceTest {

    @Mock
    private CloudVendorRepo repo;
    private InterService service;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        service = new CloudVendorService(repo);
        cloudVendor = new CloudVendor(1L,"rb",564654L);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void TestcreateCloud() {
        mock(CloudVendorService.class);
        mock(CloudVendorRepo.class);

        when(repo.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(service.createCloud(cloudVendor)).isEqualTo("Saved to DB");
    }

    @Test
    void updateCloud() {
        mock(CloudVendorService.class);
        mock(CloudVendorRepo.class);

        when(repo.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(service.updateCloud(cloudVendor)).isEqualTo("Updated");
    }

    @Test
    void deleteCloud() {
        mock(CloudVendorService.class);
        mock(CloudVendorRepo.class , Mockito.CALLS_REAL_METHODS);

       doAnswer(Answers.CALLS_REAL_METHODS).when(repo).deleteById(any());
        assertThat(service.deleteCloud(1)).isEqualTo("delete successfully");

    }

    @Test
    void getCloudId() {
        mock(CloudVendorService.class);
        mock(CloudVendorRepo.class);

        when(repo.findById(1L)).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(service.getCloudId(1L)).isEqualTo(cloudVendor);
    }

    @Test
    void getAllCloud() {
        mock(CloudVendorService.class);
        mock(CloudVendorRepo.class);

       when(repo.findAll()).thenReturn((new ArrayList<CloudVendor>((Collections.singleton(cloudVendor) ))));
        assertThat(service.getAllCloud()).isEqualTo(new ArrayList<CloudVendor>((Collections.singleton(cloudVendor))))   ;
    }
}