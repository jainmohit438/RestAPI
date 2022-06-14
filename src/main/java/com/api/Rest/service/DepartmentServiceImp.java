package com.api.Rest.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.api.Rest.entity.Department;
import com.api.Rest.error.DepartmentNotFoundException;
import com.api.Rest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DepartmentServiceImp implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);//Department will save into database
    }

    @Override
    public List<Department> fetchDepartmentList() {

        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById (Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department is not avlailable");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department db=departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            db.setDepartmentName(null);
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            db.setDepartmentCode(null);
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            db.setDepartmentAddress(null);
        }
        return departmentRepository.save(db);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
