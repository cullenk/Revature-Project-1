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

    public AdoptionRecord addNewAdoptionRecord(String firstName, String lastName, String breed, String gender, String puppy_name){
        AdoptionRecord newRecord = adr.addNewAdoptionRecord(firstName, lastName, breed, gender, puppy_name);
        return newRecord;
    }

    public boolean updateAdoptionRecord(int id, String firstName, String lastName, String breed, String gender, String puppy_name){
        adr.updateAdoptionRecord(id, firstName, lastName, breed, gender, puppy_name);
        return true;
    }

    public boolean deleteAdoptionRecord(int id){
       adr.deleteAdoptionRecord(id);
       return true;
    }

    public List<AdoptionRecord> getAdoptionRecordByLastName(String lastName) throws IOException {
        List<AdoptionRecord> returnedRecordList = adr.getAdoptionRecordByLastName(lastName);
        return returnedRecordList;
    }

    public List<AdoptionRecord> getAdoptionRecordById(int id) throws IOException {
        return adr.getAdoptionRecordById(id);
    }

    public List<AdoptionRecord> getMostPopularBreeds() throws IOException {
        return adr.getMostPopularBreeds();
    }
}