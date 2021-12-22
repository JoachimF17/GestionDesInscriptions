package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Schedule
{
    ArrayList<Activity> activities = new ArrayList<>();

    public Activity addActivity(LocalDateTime start, LocalDateTime end, String name, ActivityType type)
    {
        Activity addActivity = new Activity(start, end, name, type);

        activities.add(addActivity);

        return addActivity;
    }
}
