package com.cts.Project.SportsComplexManagementSystem.Controller;

import com.cts.Project.SportsComplexManagementSystem.Model.SportsInfo;
import com.cts.Project.SportsComplexManagementSystem.Service.SportsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api/sports")
public class SportsInfoController {

    @Autowired
    private final SportsInfoService sportsInfoService;

    @Autowired
    public SportsInfoController(SportsInfoService sportsInfoService) {
        this.sportsInfoService=sportsInfoService;
    }


    @CrossOrigin
    @GetMapping("/allsports")
    public List<SportsInfo> getAllSportsInfo() {
        return sportsInfoService.getSportsInfo();
    }

    @GetMapping("/{sportId}")
    public SportsInfo getSportsInfoById(@PathVariable Long sportId) {
        return sportsInfoService.getSportsInfoById(sportId);
    }

    @CrossOrigin
    @PostMapping("/addsport")
    public SportsInfo createSportsInfo(@RequestBody SportsInfo sportsInfo) {
        return sportsInfoService.addSportsInfo(sportsInfo);
    }

    @CrossOrigin
    @PutMapping("/{sportId}")
    public SportsInfo updateSportsInfo(@PathVariable Long sportId, @RequestBody SportsInfo updatedSportsInfo) {

        return sportsInfoService.updateSportsInfo(sportId, updatedSportsInfo);
    }

    @CrossOrigin("http://localhost:4200/")
    @DeleteMapping("/{sportId}")
    public void deleteSportsInfo(@PathVariable Long sportId)  {
        sportsInfoService.deleteSportsInfo(sportId);
    }
}

