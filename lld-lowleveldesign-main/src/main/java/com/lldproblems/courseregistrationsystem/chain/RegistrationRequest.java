package com.lldproblems.courseregistrationsystem.chain;

import com.lldproblems.courseregistrationsystem.model.CourseOffering;
import com.lldproblems.courseregistrationsystem.model.Student;

public record RegistrationRequest(Student student, CourseOffering offering) {}
