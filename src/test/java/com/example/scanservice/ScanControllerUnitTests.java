package com.example.scanservice;

import com.example.scanservice.repository.ScanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ScanControllerUnitTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScanRepository scanRepository;

    private ObjectMapper mapper = new ObjectMapper();
}
