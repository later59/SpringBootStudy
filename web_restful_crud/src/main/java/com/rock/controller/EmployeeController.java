package com.rock.controller;

import com.rock.dao.EmployeeDao;
import com.rock.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String getEmps(Map map){
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps",employees);
        return "emp/list";
    }
}
