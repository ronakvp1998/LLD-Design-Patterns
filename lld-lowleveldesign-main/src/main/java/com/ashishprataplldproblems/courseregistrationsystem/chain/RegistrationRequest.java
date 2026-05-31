package com.ashishprataplldproblems.courseregistrationsystem.chain;

import com.ashishprataplldproblems.courseregistrationsystem.model.CourseOffering;
import com.ashishprataplldproblems.courseregistrationsystem.model.Student;

public record RegistrationRequest(Student student, CourseOffering offering) {}
