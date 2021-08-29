package com.example.tez.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.util.List;

public class GroupedTasks {
    @Element(name = "groupedTask", required = false)
    GroupedTask groupedTask;

    @ElementList(entry = "task", inline = true)
    List<testRes> task;

    public GroupedTask getGroupedTask() {
        return groupedTask;
    }

    public void setGroupedTask(GroupedTask groupedTask) {
        this.groupedTask = groupedTask;
    }

    @Attribute(name = "mainRideId")
    String mainRideId;
    public String getMainRideId() {
        return mainRideId;
    }

    public void setMainRideId(String mainRideId) {
        this.mainRideId = mainRideId;
    }



    public List<testRes> getTask() {
        return task;
    }

    public void setTask(List<testRes> task) {
        this.task = task;
    }
}
