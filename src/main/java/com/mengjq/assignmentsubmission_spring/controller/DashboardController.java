package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.StudentMapper;
import com.mengjq.assignmentsubmission_spring.service.AssignService;
import com.mengjq.assignmentsubmission_spring.service.MyFileService;
import com.mengjq.assignmentsubmission_spring.util.AssignProgress;
import com.mengjq.assignmentsubmission_spring.util.DashboardTitleCard;
import com.mengjq.assignmentsubmission_spring.util.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    AssignService assignService;
    @Autowired
    MyFileService myFileService;
    StudentMapper studentMapper;


    @GetMapping("/titleCards")
    public List<DashboardTitleCard> titleCard() {
        List<DashboardTitleCard> titleCards = new ArrayList<>();
        // query all assign count
        Integer assignCount =  assignService.countAllAssigns();
        System.out.println("assignCount = " + assignCount);
        // query all file count
        String fileCount = String.valueOf(myFileService.countAll());
        // query all assign is not finished count
        Integer assignNotFinishedCountInt = assignService.countAssignNotFinished();
        String assignNotFinishedCount = String.valueOf(assignNotFinishedCountInt);
        // query all student count
        Integer studentCountInt = studentMapper.selectCounts();
        String studentCount = String.valueOf(studentCountInt);
        titleCards.add(new DashboardTitleCard("在库作业", String.valueOf(assignCount), "fas fa-calendar"));
        titleCards.add(new DashboardTitleCard("在库文件", fileCount, "fas fa-comments"));
        titleCards.add(new DashboardTitleCard("在收作业", assignNotFinishedCount, "fas fa-database"));
        titleCards.add(new DashboardTitleCard("学生数量", studentCount, "fas fa-clipboard-list"));
        return titleCards;
    }

    @GetMapping("/assignProgress")
    public List<AssignProgress> assignProgress() {
        List<AssignProgress> AssignProgress = new ArrayList<>();
        AssignProgress.add(new AssignProgress("作业1", "10", "100", "2023-04-21 23:59:59", "2021-01-21 23:59:59"));
        AssignProgress.add(new AssignProgress("作业2", "20", "100", "2023-04-21 23:59:59", "2021-01-21 23:59:59"));
        AssignProgress.add(new AssignProgress("作业3", "30", "100", "2023-04-21 23:59:59", "2021-01-21 23:59:59"));
        AssignProgress.add(new AssignProgress("作业4", "40", "100", "2023-04-21 23:59:59", "2021-01-21 23:59:59"));
        return AssignProgress;
    }

    @GetMapping("/notices")
    public List<Notice> getAllNotices() {
        List<Notice> notices = new ArrayList<>();
        notices.add(new Notice(1,"张晨光", "3", "2021-01-21 23:59:59", "2021-01-21 23:59:59", false));
        notices.add(new Notice(2,"张晨光", "3", "2021-01-21 23:59:59", "2021-01-21 23:59:59", false));
        notices.add(new Notice(3,"张晨光", "3", "2021-01-21 23:59:59", "2021-01-21 23:59:59", true));
        return notices;
    }


}
