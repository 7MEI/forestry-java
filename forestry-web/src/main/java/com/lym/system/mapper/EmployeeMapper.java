package com.lym.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LHC
 * @since 2021-06-25
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 分页获取员工列表
     * @param page
     * @param employee
     */
    IPage<Employee> getEmployeePage(@Param("page") Page<Employee> page, @Param("employee") Employee employee,
                                    @Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 获取员工最大编号
     * @return
     */
    String getMaxWorkID();

    /**
     * 导出员工表格
     * @param id
     * @return
     */
    List<Employee> getEmployeeList(@Param("id") Integer id);

    /**
     * 查询一些列添加需要的ID
     * @param employeeMap
     * @return
     */
    Employee getIdSelectNationByName(Map<String,String> employeeMap);

    /**
     * 获取所有员工和员工账套信息
     * @param employeePage
     * @return
     */
    IPage<Employee> getAllEmpSalary(Page<Employee> employeePage);

    /**
     * 更新员工账套信息
     * @param eid
     * @param eSid
     */
    Boolean updateEmpEsid(@Param("eid") Integer eid, @Param("eSid") Integer eSid);
}
