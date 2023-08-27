package com.rb.Rest_demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rb.Rest_demo.model.CloudVendor;
import com.rb.Rest_demo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService service;

    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();



    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor(1L,"rb",564654L);
        cloudVendorTwo = new CloudVendor(2L,"uk",56234654L);
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDetail() throws Exception {
        when(service.getCloudId(1L)).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloud/" +"1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllDetail() throws Exception {
        when(service.getAllCloud()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloud")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void CreateDetail() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(service.createCloud(cloudVendorOne)).thenReturn(String.valueOf(cloudVendorOne));
        this.mockMvc.perform(post("/cloud")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void putDetail() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(service.createCloud(cloudVendorOne)).thenReturn(String.valueOf(cloudVendorOne));
        this.mockMvc.perform(put("/cloud")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteDetail() throws Exception {
        when(service.deleteCloud(1L))
                .thenReturn("");
        this.mockMvc.perform(delete("/cloud/" + "1"))
                .andDo(print()).andExpect(status().isOk());

    }
}