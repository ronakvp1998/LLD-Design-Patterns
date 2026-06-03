package com.ashishprataplldproblems.hard.courseregistrationsystem;

import com.ashishprataplldproblems.hard.courseregistrationsystem.chain.RegistrationRequest;
import com.ashishprataplldproblems.hard.courseregistrationsystem.exception.RegistrationException;
import com.ashishprataplldproblems.hard.courseregistrationsystem.repository.CourseRepository;
import com.ashishprataplldproblems.hard.courseregistrationsystem.repository.StudentRepository;

public class CourseRegistrationSystemFacade {
    private final CourseRegistrationService courseRegistrationService = new CourseRegistrationService();
    private final StudentRepository studentRepo = StudentRepository.getInstance();
    private final CourseRepository courseRepo = CourseRepository.getInstance();

    public void registerStudentForCourse(String studentId, String offeringId) {
        studentRepo.findById(studentId).ifPresentOrElse(student ->
                courseRepo.findOfferingById(offeringId).ifPresentOrElse(offering -> {
                            try {
                                courseRegistrationService.register(new RegistrationRequest(student, offering));
                            } catch (RegistrationException e) {
                                System.err.println("Registration Failed for " + student.getName() + ": " + e.getMessage());
                            }
                        }, () -> System.err.println("Error: Course offering " + offeringId + " not found.")
                ), () -> System.err.println("Error: Student " + studentId + " not found."));
    }

    public void dropStudentFromCourse(String studentId, String offeringId) {
        studentRepo.findById(studentId).ifPresent(student ->
                courseRepo.findOfferingById(offeringId).ifPresent(offering -> {
                    offering.dropStudent(student);
                    System.out.println(student.getName() + " dropped from " + offering.getCourse().getCourseCode());
                })
        );
    }
}
