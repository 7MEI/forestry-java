package com.lym.system.controller;

import com.lym.reponse.Result;
import com.lym.system.service.AliOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author NieChangan
 */
@Api(tags = "头像管理")
@RestController
//@CrossOrigin
public class AliOssController {

    @Autowired
    private AliOssService aliOssService;

    @ApiOperation(value = "上传图片文件")
    @PostMapping("/uploadImgFile")
    public Result uploadImgFile(MultipartFile file){
        String s = aliOssService.upload(file);
        return Result.ok().data("url",s);
    }

    @ApiOperation(value = "删除替换之后的头像")
    @PostMapping("/deleteImgFile")
    public Result deleteImgFile(String file){
        //https://xinguan-parent.oss-cn-hangzhou.aliyuncs.com/2020/10/20/300f7c9d6546486eb55d825d4edcf668.png
        try {
            String[] split = file.split(".com/");
            System.out.println(split[1]);
            aliOssService.deleteFile(split[1]);
            return Result.ok();
        }catch (Exception e){
            //需要打印错误日志到本地系统中(服务器系统)
            return Result.error();
        }
    }


}