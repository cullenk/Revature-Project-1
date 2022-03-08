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

    public boolean addNewAdoptionRecord(String firstName, String lastName, String breed, String gender, String puppy_name){
        adr.addNewAdoptionRecord(firstName, lastName, breed, gender, puppy_name);
        return true;
    }


}