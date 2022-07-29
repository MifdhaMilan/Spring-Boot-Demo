package com.sun.travels.service;

import com.sun.travels.model.Department;
import com.sun.travels.model.Student;
import com.sun.travels.repository.DepartmentRepository;
import com.sun.travels.repository.StudentRepository;
import com.sun.travels.request.AddStudentToDepartment;
import com.sun.travels.request.DepartmentRequest;
import com.sun.travels.response.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<DepartmentResponse> createDepartment(DepartmentRequest departmentRequest){
        Department department = new Department();
        department.setName(departmentRequest.getName());
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setDepartment(department);
        departmentResponse.setMessage("department added successfully");
        departmentRepository.save(department);
        return ResponseEntity.ok(departmentResponse);
    }
    public ResponseEntity<Department> getDepartmentById(int id){
        return ResponseEntity.ok(departmentRepository.findById(id).orElse(null));
    }
    public ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(departmentRepository.findAll());
    }
    public ResponseEntity<Department> deleteDepartment(int id){
        Department deletedDepartment = getDepartmentById(id).getBody();
        try{
            departmentRepository.delete(deletedDepartment);
        }catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.ok(deletedDepartment);
    }

    public ResponseEntity<Department> updateDepartment(Department department){
        Department existingDepartment = getDepartmentById(department.getId()).getBody();
        try{
            existingDepartment.setId(department.getId());
            existingDepartment.setName(department.getName());
            departmentRepository.save(existingDepartment);
        }catch (Exception e){
            System.out.println(e);
        }
        return ResponseEntity.ok(existingDepartment);
    }

    public ResponseEntity<Student> addStudentToDepartment(AddStudentToDepartment addStudentToDepartment){
        Department department = getDepartmentById(addStudentToDepartment.getDepartmentId()).getBody();
        Student student = studentRepository.findById(addStudentToDepartment.getStudentId()).orElse(null);
        student.setDepartment(department);
        return ResponseEntity.ok(studentRepository.save(student));
    }
}
