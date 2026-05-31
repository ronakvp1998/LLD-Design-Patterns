package com.ashishprataplldproblems.courseregistrationsystem.observer;

import com.ashishprataplldproblems.courseregistrationsystem.model.CourseOffering;

public interface CourseOfferingObserver {
    void onSpotAvailable(CourseOffering offering);
}
