package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.MedicalAid;
import za.ac.cput.factory.MedicalAidFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/*
    MedicalAidControllerTest.java
    Test for the MedicalAid
    Author: Shina Kara (219333181).
    Date: 23 October 2022
*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class  MedicalAidControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private InvoiceController controller;
    @Autowired private TestRestTemplate restTemplate;

    private MedicalAid medicalAid;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.medicalAid = MedicalAidFactory.createMedicalAid("10122","Sarah", "Lansdowne");
        this.baseUrl = "http://localhost:" + this.port + "/hospital-system/medicalaid/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<MedicalAid> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .postForEntity(url, this.medicalAid, MedicalAid.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.medicalAid.getMedicalNum();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.medicalAid.getMedicalNum();
        System.out.println(url);
        ResponseEntity<MedicalAid> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .getForEntity(url, MedicalAid.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<MedicalAid []> response =
                this.restTemplate
                        .withBasicAuth("admin-user", "65ff7492d30")
                        .getForEntity(url, MedicalAid[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}