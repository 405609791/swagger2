package fun.codefarmer.swagger2.controller;

import fun.codefarmer.swagger2.bean.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.jws.soap.SOAPBinding;

/**
 * swagger2 主要就是注解的使用，知道每个注解的用法，需要了解下：security放行swagger2
 * @ @ClassName UserController
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/26 18:58
 **/
@RestController
//swagger2生成接口文档时，有中文描述
@Api(tags="用户数据接口")
public class UserController {

    //swagger2生成接口文档时，有中文描述
    @ApiOperation(value = "查询用户",notes = "根据用户id查询用户")
    //required 在swagger中是必填，步能替换代码中的必填
    @ApiImplicitParam(name = "id",value = "用户id",required = true,defaultValue = "99")
    @GetMapping("/user")
    public User getUserById(Integer id) {

        User user = new User();
        user.setId(id);
        return user;
    }

    //swagger2生成接口文档时，有中文描述
    @ApiOperation(value = "查询用户",notes = "根据用户id查询用户")
    //required 在swagger中是必填，步能替换代码中的必填
    @ApiImplicitParam(name = "id",value = "用户id",required = true,defaultValue = "99")
    @ApiResponses({
            @ApiResponse(code = 200,message = "删除成功"),
            @ApiResponse(code = 500,message = "删除失败")
    })
    @DeleteMapping("/user/{id}")
    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById"+id);
    }

    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id",value = "用户id",required = true,defaultValue = "99"),
            @ApiImplicitParam(name = "username",value = "用户名",required = true,defaultValue = "codefarmer")}
    )
    @ApiOperation(value = "更新用户",notes = "根据用户id更新用户名")
    //生成接口忽略它，不生成
    @ApiIgnore
    @PutMapping("/user")
    public User updateUsernameById(Integer id,String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @ApiOperation(value = "添加用户",notes = "添加用户接口")
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        User user1 = new User();
        return user1;
    }
}
