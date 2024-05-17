package com.cts.Project.SportsComplexManagementSystem.Service;

import com.cts.Project.SportsComplexManagementSystem.Model.SportsInfo;
import com.cts.Project.SportsComplexManagementSystem.Repository.SportsInfoRepository;
import com.cts.Project.SportsComplexManagementSystem.UserDefinedExceptions.NotExistInDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsInfoService {

    @Autowired
    private final SportsInfoRepository sportsInfoRepository;

    @Autowired
    public SportsInfoService(SportsInfoRepository sportsInfoRepository) {
        this.sportsInfoRepository = sportsInfoRepository;
    }

    public List<SportsInfo> getSportsInfo() {
        List<SportsInfo> sportsInfo = sportsInfoRepository.findAll();
        if(sportsInfo.isEmpty()) {
            throw new NotExistInDatabase("No Sports found in Database");
        }
        return sportsInfo;
    }


    public SportsInfo getSportsInfoById(Long id) {
        return sportsInfoRepository.findById(id)
                .orElseThrow(()-> new NotExistInDatabase("sport Id not found in Database: " + id));
    }

    public SportsInfo addSportsInfo(SportsInfo sportsInfo) {
        return sportsInfoRepository.save(sportsInfo);
    }


    public SportsInfo updateSportsInfo(long sportId, SportsInfo sportsInfo) {

        SportsInfo existingSport = getSportsInfoById(sportId);
        if(sportsInfo.getSportName() != null){
            existingSport.setSportName(sportsInfo.getSportName());
        }
        if (sportsInfo.getMinimumPlayers() != 0){
            existingSport.setMinimumPlayers(sportsInfo.getMinimumPlayers());
        }
        if (sportsInfo.getCostPerHour() != 0){
            existingSport.setCostPerHour(sportsInfo.getCostPerHour());
        }

        return sportsInfoRepository.save(existingSport);
    }
    public void deleteSportsInfo(Long id) {
        sportsInfoRepository.deleteById(id);

    }


}