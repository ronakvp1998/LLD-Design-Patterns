package com.ashishprataplldproblems.hard.courseregistrationsystem.chain;

import com.ashishprataplldproblems.hard.courseregistrationsystem.model.CourseOffering;
import com.ashishprataplldproblems.hard.courseregistrationsystem.model.Student;

public record RegistrationRequest(Student student, CourseOffering offering) {}
