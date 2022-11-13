package com.example.scanservice;

import com.example.scanservice.model.Scan;
import com.example.scanservice.repository.ScanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ScanControllerUnitTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScanRepository scanRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenScans_whenFindScansByUserName_thenReturnJsonScanService() throws Exception{
        Scan scanUser1 = new Scan("jan","VW",4);
        Scan scanUser2 = new Scan("john","BMW",5);
        Scan scanUser3 = new Scan("jan","BMW",5);
        List<Scan> scanList = new ArrayList<>();
        scanList.add(scanUser1);
        scanList.add(scanUser3);

        given(scanRepository.findScansByUserName("jan")).willReturn(scanList);

        mockMvc.perform(get("/scans/user/{userName}","jan"))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].userName",is("jan")))
            .andExpect(jsonPath("$[0].carBrand",is("VW")))
            .andExpect(jsonPath("$[0].scoreNumber",is(4)))
            .andExpect(jsonPath("$[1].userName",is("jan")))
            .andExpect(jsonPath("$[1].carBrand",is("BMW")))
            .andExpect(jsonPath("$[1].scoreNumber",is(5)));
    }
}


