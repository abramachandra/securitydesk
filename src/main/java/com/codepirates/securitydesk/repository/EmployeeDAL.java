package com.codepirates.securitydesk.repository;

import com.codepirates.securitydesk.model.Employee;
import com.codepirates.securitydesk.model.LateNightConeyanceModel;

import java.util.List;

public interface EmployeeDAL {

    List<LateNightConeyanceModel> getAllEmployee();

    Employee getEmployeeById(String employeeId);

    LateNightConeyanceModel addNewLateNightEntry(LateNightConeyanceModel lateNightConeyanceModel);
}
