package com.camelot.autogenerator.service.impl;

import com.camelot.autogenerator.domain.User;
import com.camelot.autogenerator.mapper.UserMapper;
import com.camelot.autogenerator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyp
 * @since 2019-02-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
