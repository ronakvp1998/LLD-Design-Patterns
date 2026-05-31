package com.lldproblems.courseregistrationsystem.observer;

import com.lldproblems.courseregistrationsystem.model.CourseOffering;

public interface CourseOfferingObserver {
    void onSpotAvailable(CourseOffering offering);
}
