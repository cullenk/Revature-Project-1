package services;

import model.AdoptionRecord;
import model.Breed;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import util.HibernateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionRecordServiceTest {
    AdoptionRecord adoptionRecord;
    AdoptionRecord adoptionRecordFromMock;
    AdoptionRecordService mockService;

//    @BeforeAll
//    public void SetUpMocks() throws IOException {
//        adoptionRecord = new AdoptionRecord("Jane", "Doe", "Pug", "male", "Bowser");
//        adoptionRecordFromMock = new AdoptionRecord("Jane", "Doe", "Pug", "male", "Bowser");
//        mockService = Mockito.mock(AdoptionRecordService.class);
//
//        Mockito.when(mockService.getAdoptionRecordByLastName("Doe")).thenReturn(adoptionRecordFromMock);
//
//        mockConnection = Mockito.mock(HibernateUtil.class);
//        mockPrepared = Mockito.
//    }


    @Test
        void GetsAllAdoptionRecords() throws IOException {


        }

        @Test
        void AddsNewAdoptionRecord() throws IOException {
            String firstName = "John";
            String lastName = "Doe";
            String breed = "Pug";
            String gender = "female";
            String puppy_name = "Princess";

        }

        @Test
        void UpdatesAnAdoptionRecord() throws IOException {

        }

        @Test
        void DeletesAnAdoptionRecord() throws IOException {

        }

}