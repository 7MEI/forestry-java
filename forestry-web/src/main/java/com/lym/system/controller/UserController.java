//package com.lym.system.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.lym.reponse.Result;
//import com.lym.system.entity.User;
//import com.lym.system.service.UserService;
//import com.lym.vo.UserVo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * <p>
// * 用户表 前端控制器
// * </p>
// *
// * @author lym
// * @since 2021-09-24
// */
////@RestController
//@RequestMapping("/user")
//@Api(value = "系统用户模块",tags = "系统用户接口")
////@CrossOrigin:解决跨域问题
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//
////    @GetMapping
////    @ApiOperation(value = "用户列表",notes = "查询用户所有信息")
////    private Result findUser(){
////        List<User> list = userService.list();
////        return Result.ok().data("user",list);
////    }
//////    查询单个用户
////    @GetMapping("/{id}")
////    @ApiOperation(value = "查询单个用户",notes = "通过id查询用户信息")
////    public Result getUserById(@PathVariable("id") Long id){
////        User user = userService.getById(id);
////        if(user!=null){
////            return Result.ok().data("user",user);
////        }else{
////            throw new BusinessException(ResultCode.USER_NOT_FOUND_EXCEPTION.getCode(), ResultCode.USER_NOT_FOUND_EXCEPTION.getMessage());
////        }
////    }
//
//    /*
//    * 分页查询用户
//    *current:当前页
//    size:每页显示条数
//     */
//    @GetMapping("/findUser")
//    public Result findUserList(@RequestParam(required = true,defaultValue = "1")Integer current,
//                               @RequestParam(required = true,defaultValue = "6")Integer size)
//    {
//        Page<User> userPage = new Page<>(current,size);
//       // LambdaQueryWrapper<User> Wrapper = new LambdaQueryWrapper<>();
//        Page<User> page = userService.page(userPage);
//        long total = page.getTotal();
//        List<User> records = page.getRecords();
//        return Result.ok().data("total",total).data("records",records);
//    }
////    使用RequestBody必须使用post方法
//    @PostMapping("/findUserPage")
//    public Result findUserPage(@RequestParam(required = true,defaultValue = "1")Integer current,
//                               @RequestParam(required = true,defaultValue = "6")Integer size,
//                               @RequestBody UserVo userVo)
//
//
//    {
//        Page<User> userPage = new Page<>(current,size);
//        // LambdaQueryWrapper<User> Wrapper = new LambdaQueryWrapper<>();
//        QueryWrapper<User> wrapper= getWrapper(userVo);
//        IPage<User> page = userService.page(userPage,wrapper);
//        long total = page.getTotal();
//        List<User> records = page.getRecords();
//        return Result.ok().data("total",total).data("records",records);
//    }
//    /**
//     * 封装查询条件
//     *
//     * @param userVo
//     * @return
//     */
//    private QueryWrapper<User> getWrapper(UserVo userVo) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        if (userVo != null) {
//            if (!StringUtils.isEmpty(userVo.getDepartmentId())) {
//                queryWrapper.eq("department_id", userVo.getDepartmentId());
//            }
//            if (!StringUtils.isEmpty(userVo.getUsername())) {
//                queryWrapper.eq("username", userVo.getUsername());
//            }
//            if (!StringUtils.isEmpty(userVo.getEmail())) {
//                queryWrapper.eq("email", userVo.getEmail());
//            }
//            if (!StringUtils.isEmpty(userVo.getSex())) {
//                queryWrapper.eq("sex", userVo.getSex());
//            }
//            if (!StringUtils.isEmpty(userVo.getNickname())) {
//                queryWrapper.eq("nickname", userVo.getNickname());
//            }
//        }
//        return queryWrapper;
//    }
//    /*
//    添加用户
//     */
//    @ApiOperation(value = "添加用户", notes = "添加用户信息")
//    @PostMapping("/addUser")
//    public Result addUser(@RequestBody User user){
//        try{
//            userService.addUser(user);
//            return Result.ok();
//        }catch (Exception e){
//            return Result.error();
//        }
//    }
//}
//
//
