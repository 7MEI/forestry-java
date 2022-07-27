package com.lym.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.Employee;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.RespPageBean;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LHC
 * @since 2021-06-25
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 分页获取员工列表
     * @param currentPage
     * @param size
     * @param employee
     * @return
     */
    RespPageBean getEmployeeList(Integer currentPage, Integer size, Employee employee, String startDate, String endDate);

    /**
     * 获取工号
     * @return
     */
    RespBean getMaxWorkID();

    /**
     * 获取工号 方法2
     * @return
     */
    RespBean getMaxWorkID2();

    /**
     * 添加员工
     * @param employee
     */
    RespBean addEmp(Employee employee);

    /**
     * 导出员工表格
     * @param id
     */
    void getEmployee(Integer id, HttpServletResponse response);

    /**
     * 获取员工添加所需要的各种id
     * @param employeeMap
     * @return
     */
    Employee getIdSelectNationByName(Map<String,String> employeeMap);

    /**
     * 获取所有工资账套
     * @param currentPage
     * @param pageSize
     * @return
     */
    RespPageBean getAllEmpSalary(Integer currentPage, Integer pageSize);

    /**
     * 更新员工账套信息
     * @param eid
     * @param eSid
     */
    Boolean updateEmpEsid(Integer eid, Integer eSid);
}
