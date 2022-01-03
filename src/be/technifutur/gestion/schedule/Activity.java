package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Activity implements Serializable
{
    //atributs
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String name;
    private ActivityType activityType;

    //methodes
    //constructeur
    public Activity(LocalDateTime startTime, LocalDateTime endTime, String name, ActivityType activityType)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.activityType = activityType;
    }

    //getters
    public LocalDateTime getStartTime()
    {
        return startTime;
    }

    public LocalDateTime getEndTime()
    {
        return endTime;
    }

    public String getName()
    {
        return name;
    }

    public ActivityType getActivityType()
    {
        return activityType;
    }
    //fin getters

    //setters
    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime)
    {
        this.endTime = endTime;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setActivityType(ActivityType activityType)
    {
        this.activityType = activityType;
    }
    //fin setters


    @Override
    public String toString()
    {
        return "Activity{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", name='" + name + '\'' +
                ", activityType=" + activityType +
                '}';
    }
}
