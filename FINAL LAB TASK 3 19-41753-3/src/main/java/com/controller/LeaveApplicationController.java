package com.controller;

import com.domain.LeaveApplication;
import com.domain.LeaveType;
import com.domain.Student;
import com.service.LeaveApplicationService;
import com.service.LeaveTypeService;
import com.service.StudentService;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

@Controller
@RequestMapping("/leaveApplications")
public class LeaveApplicationController {

    private LeaveApplicationService leaveApplicationService;

    private LeaveTypeService leaveTypeService;

    private StudentService studentService;

    public LeaveApplicationController(LeaveApplicationService leaveApplicationService, LeaveTypeService leaveTypeService, StudentService studentService) {
        this.leaveApplicationService = leaveApplicationService;
        this.leaveTypeService = leaveTypeService;
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public void create() throws Exception {
        LeaveType leaveType = leaveTypeService.get(1L);
        Student student = studentService.get(4L);

        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setStudent(student);
        leaveApplication.setLeaveType(leaveType);

        leaveApplication.setFromDate(LocalDate.of(2022, 10, 20));
        leaveApplication.setToDate(LocalDate.of(2022, 10, 28));
        leaveApplication.setTotalDays(9);
        leaveApplication.setReason("High Fever");
        boolean result = leaveApplicationService.insert(leaveApplication);
        if (!result) {
            throw new Exception("Constraint Violation");
        }
    }

    @RequestMapping("/get")
    public void get() {
        LeaveApplication leaveApplication = leaveApplicationService.get(1L);
        System.out.println(leaveApplication.getId() + " " + leaveApplication.getLeaveType().getCategory() + " " + leaveApplication.getTotalDays() + " " + leaveApplication.getReason());
    }



    @GetMapping("/leaveApplication")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String title) {
        try {
            List<Student> studentss = new ArrayList<Student>();

            if (title == null)
                LeaveApplicationRepository.findAll().forEach(studentService::add);
            else
                LeaveApplicationRepository.findByTitleContaining(title).forEach(studentService::add);

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        DynamicType.Builder.FieldDefinition.Optional<Student> studentData = tutorialRepository.findById(id);

        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        @PostMapping("/create")
        public ResponseEntity<Students> createStudent(@RequestBody Student student) {
            try {
                Student _student = LeaveApplicationRepository
                        .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
                return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        Optional<Student> StudentData = LeaveApplicationRepository.findById(id);

        if (LeaveApplicationData.isPresent()) {
            Student _student = StudentData.get();
            _student.setTitle(student.getTitle());
            _student.setDescription(student.getDescription());
            _student.setPublished(student.isPublished());
            return new ResponseEntity<>(LeaveApplicationRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
        try {
            LeaveApplication.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students")
    public ResponseEntity<HttpStatus> deleteAllStudents() {
        try {
            LeaveApplication.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/students/published")
    public ResponseEntity<List<Student>> findByPublished() {
        try {
            List<Student> students = LeaveApplication.findByPublished(true);

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
