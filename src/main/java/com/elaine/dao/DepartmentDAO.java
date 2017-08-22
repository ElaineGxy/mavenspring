package com.elaine.dao;

import com.elaine.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentDAO {
    String getDepartmentById(int id);
    List<DepartmentEntity> getAllDepartment();
    public void saveADepartment(DepartmentEntity departmentEntity);
}
