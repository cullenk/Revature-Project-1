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

    AdoptionRecordService recordService = new AdoptionRecordService();

    @Test
        void GetsAdoptionRecordByLastName() throws IOException {
            String lastName = "Kuch";
            List<AdoptionRecord> returnedRecordList = recordService.getAdoptionRecordByLastName(lastName);
            for(AdoptionRecord ar : returnedRecordList){
                assertTrue(ar.lastName.equalsIgnoreCase(lastName));
            }
        }

}