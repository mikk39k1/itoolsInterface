package com.example.itoolsinterface.controller;

import com.example.itoolsinterface.model.TemporaryAccessData;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TemporaryAccessController {

    private List<TemporaryAccessData> temporaryAccessDataList = new ArrayList<>();

    @Scheduled(cron = "0 0 0 * * *")
    public void clearDataFromListAtMidnight() {
        LocalDateTime now = LocalDateTime.now();
        temporaryAccessDataList.removeIf(data ->
                data.getLocalDateTime().toLocalDate().isAfter(now.toLocalDate()));
    }


    @PostMapping("/getTemporaryAccess")
    public String submitTemporaryAccess(@RequestParam("hourAmount") int hourAmount,
                                        @RequestParam("mailGroup") String mailGroup,
                                        @RequestParam("initials") String initials) {
        TemporaryAccessData temporaryAccessData = new TemporaryAccessData(hourAmount, mailGroup, initials, LocalDateTime.now());
        temporaryAccessDataList.add(temporaryAccessData);
        if (temporaryAccessDataList.size() >= 2){
            temporaryAccessDataList.remove(0);
        }

        return "Din anmodning er sendt, afvent svar på mail.";
    }

    @GetMapping("/getTemporaryAccessData")
    public List<TemporaryAccessData> getTemporaryAccessData() {
        return temporaryAccessDataList;
    }
}