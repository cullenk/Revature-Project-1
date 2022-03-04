package services;

import model.AdoptionRecord;
import respositories.AdoptionRecordRepository;

import java.io.IOException;
import java.util.List;

public class AdoptionRecordService {
    AdoptionRecordRepository adr;
    public AdoptionRecordService(){
        adr = new AdoptionRecordRepository();
    }

    public List<AdoptionRecord> getAllAdoptionRecords(){
        return adr.getAdoptionRecords();
    }


}