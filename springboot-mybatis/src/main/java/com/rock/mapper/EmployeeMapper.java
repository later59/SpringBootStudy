package com.rock.mapper;

import com.rock.dao.Employee;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    Employee insertEmp(Employee employee);
}
