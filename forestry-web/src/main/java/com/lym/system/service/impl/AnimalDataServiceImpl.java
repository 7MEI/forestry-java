package com.lym.system.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.AnimalData;
import com.lym.system.entity.Animals;
import com.lym.system.entity.PlantData;
import com.lym.system.entity.RespPageBean;
import com.lym.system.mapper.AnimalDataMapper;
import com.lym.system.service.AnimalDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-11-21
 */
@Service
public class AnimalDataServiceImpl extends ServiceImpl<AnimalDataMapper, AnimalData> implements AnimalDataService {

    @Autowired
    private AnimalDataMapper animalDataMapper;
    @Override
    public RespPageBean getAnimalsByPage(Integer currentPage, Integer size, AnimalData animalData) {
        Page<Animals> page = new Page<>(currentPage,size);
        IPage<Animals> adminByPage = animalDataMapper.getAnimalsByPage(page, animalData);
        RespPageBean respPageBean = new RespPageBean(adminByPage.getTotal(), adminByPage.getRecords());
        return respPageBean;
    }

    @Override
    public void getOrder(Integer id, HttpServletResponse response) {
        List<AnimalData> orderList = animalDataMapper.getOrderList(id);
        // 导出员工信息基本设置
        // title：文件内容中的标题名，第一行 sheetName：文件中的表名 ExcelType:导出的表格文件名后缀， .HSSF 后缀为.xls，.XSSF 为 .xlsx，
        // 2003版本的导出速度更快，并且用 2003 或者 2003 以上的office都能打开，2007版本的office只能向上兼容
        ExportParams exportParams = new ExportParams("动物历史数据信息表", "历史数据信息", ExcelType.HSSF);
        // 查询到的 list 导出的表格数据，此时还没有输出文件
        Workbook sheets = ExcelExportUtil.exportExcel(exportParams, AnimalData.class, orderList);

        BufferedOutputStream outputStream = null;
        try {
            // 以流的形式输出,防止文件乱码
            response.setContentType("application/octet-stream");
            // 防止下载出来的文件名中文乱码
            // URLEncoder.encode("员工信息表.xls","UTF-8") ： 输出的文件名并且设置编码
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("动物历史数据信息表.xls","UTF-8"));
            // 拿到输出流
            outputStream = new BufferedOutputStream(response.getOutputStream());
            // 导出的表格数据，以流的形式输出，提供给浏览器下载
            sheets.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
