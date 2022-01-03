package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.TreeMap;

public class Schedule implements Serializable
{
    TreeMap<String, Activity> activities = new TreeMap<>();

    public Activity addActivity(LocalDateTime start, LocalDateTime end, String name, ActivityType type)
    {
        Activity addActivity = new Activity(start, end, name, type);

        activities.put(name.toUpperCase(), addActivity);

        return addActivity;
    }
}
