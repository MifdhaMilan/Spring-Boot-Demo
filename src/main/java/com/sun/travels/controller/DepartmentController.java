package com.sun.travels.controller;

import com.sun.travels.model.Department;
import com.sun.travels.model.Student;
import com.sun.travels.request.AddStudentToDepartment;
import com.sun.travels.request.DepartmentRequest;
import com.sun.travels.response.DepartmentResponse;
import com.sun.travels.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create-department")
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest departmentRequest){
        return departmentService.createDepartment(departmentRequest);
    }

    @GetMapping("/get-department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Department>> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @DeleteMapping("/delete-department/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable int id){
        return departmentService.deleteDepartment(id);
    }

    @PutMapping("update-department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }
    @PutMapping("/add-student-to-department")
    public ResponseEntity<Student> addStudentToDepartment(@RequestBody AddStudentToDepartment addStudentToDepartment){
        return departmentService.addStudentToDepartment(addStudentToDepartment);
    }

}
