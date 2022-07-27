package com.lym.system.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lym.system.entity.*;
import com.lym.system.mapper.ApplyMapper;
import com.lym.system.mapper.OrderMapper;
import com.lym.system.service.ApplyService;
import com.lym.system.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-11-08
 */
@RestController
@RequestMapping("/or/info")
@Api(tags = "预约管理")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ApplyService applyService;
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "分页获取所有信息")
    @GetMapping("/AllInfo")
    public RespPageBean findUserPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "5")Integer size,
                                     Order order
    ){
        return orderService.getByPage(currentPage,size,order);

    }
    /*
   添加所有部门信息
    */
    @ApiOperation(value = "添加")
    @PostMapping("/addOrd")
    public RespBean addDep(@RequestBody Order order){
        if (orderService.save(order)){
            //发送邮件
            Order ord=orderMapper.getOrderList(order.getId()).get(0);
            rabbitTemplate.convertAndSend("mail.welcome",ord);

            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /*
   修改所有部门信息
    */
    @ApiOperation(value = "更新信息")
    @PutMapping("/updateOrd")
    public RespBean updataDep(@RequestBody Order order){
        if(orderService.updateById(order)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
    /*
   删除部门信息
    */
    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDep(@PathVariable Integer id){
        if (orderService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return  RespBean.error("删除失败");
    }
    /*
   批量删除部门信息
    */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/")
    public RespBean deleteDepByIds(Integer[] ids){
        if (orderService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "导出活动人员表格")
    @GetMapping(value = "/export",produces = "application/octet-stream")
    public void exportEmp(HttpServletResponse response){
        orderService.getOrder(null,response);
    }

    @ApiOperation(value = "导入员工信息")
    @PostMapping("/import")
    public RespBean importEmp(MultipartFile multipartFile){
        ImportParams params = new ImportParams();
        params.setTitleRows(1);//表的标题行数，去掉前两行(第一行表标题，第二行列标题)，如果超出表格本身的标题行数，截取数据为null
        params.setStartRows(0);//列标题和实际字段值的距离，可以设置从第几行开始截取数据，默认为0，就是列标题的下一行
        List<Apply> applyList = applyService.list();
        try {
//            InputStream inputStream = multipartFile.getInputStream();
            //设置导入使用的流 实体类 实体类的具体字段(加了Excel注解的字段)
            //返回值就是一个对象集合，里面包含了所有从文件中获取的数据
            /* 需求：此时获取的对象信息，里面有很多字段用户添加的是名字，需要将名字找到对应的ID添加导入到数据库
             *  所以需要在添加数据库之前，把名字对应的ID准备完成，实际添加用对应ID添加
             *  这个sql只需要查询一次数据库，但是如果用户传入的某一个ID查找出来为空的，其他ID也找不到
             *  如果避免这种情况，可以写 5 条 sql 查找各自的ID
             * */
            List<Order> list = ExcelImportUtil.importExcel(multipartFile.getInputStream(), Order.class, params);
            list.forEach(order -> {
                        order.setApplyid( applyList.get(applyList.indexOf(new Apply(order.getApplys().getSubject()))).getId());
            });
           if (orderService.saveBatch(list)){
            return RespBean.success("导入成功!");}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.success("导入失败");
    }
}

