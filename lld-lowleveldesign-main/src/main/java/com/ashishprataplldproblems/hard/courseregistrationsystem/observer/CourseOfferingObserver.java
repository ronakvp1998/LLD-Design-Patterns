package com.ashishprataplldproblems.hard.courseregistrationsystem.observer;

import com.ashishprataplldproblems.hard.courseregistrationsystem.model.CourseOffering;

public interface CourseOfferingObserver {
    void onSpotAvailable(CourseOffering offering);
}
