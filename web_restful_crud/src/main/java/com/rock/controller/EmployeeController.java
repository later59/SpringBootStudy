package com.rock.controller;

import com.rock.dao.DepartmentDao;
import com.rock.dao.EmployeeDao;
import com.rock.entities.Department;
import com.rock.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmps(Map map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmp(Map map) {
        //跳转到添加页面，查询所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);
        return "emp/add";
    }

    /**
     * 员工添加
     *
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String add(Employee employee) {
        System.out.println("保存的员工信息：" + employee);
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址，/代表当前项目地址
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Map map) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);
        map.put("emp", employee);
        //回到修改页面
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
