package com.soft1851.springboot.jwt.service.serviceImpl;

import com.soft1851.springboot.jwt.common.Result;
import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.service.UserService;
import com.soft1851.springboot.jwt.util.CreateToken;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wl
 * @ClassNameUserServiceImpl
 * @Description TODO
 * @Date 2020/4/15
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Result login(String num, String password ,String role) {
        if (num != null && password != null&&role!=null) {
            String token = CreateToken.getToken(num, role);
            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert sra != null;
            HttpServletResponse response = sra.getResponse();
            assert response != null;
            // 将token放在响应头返回，此处需在跨域配置中配置allowedHeaders和allowedExposedHeaders
            response.setHeader("Authorization", token);
            response.setHeader("wl","6666");
            return Result.success();
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result dothing() {
        String data = "做点什么事情";
        return Result.success(data);
    }
}
