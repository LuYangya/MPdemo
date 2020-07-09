package com.psfd.mybatisplus.demo.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.mybatisplus.demo.bean.UserEntity;
import com.psfd.mybatisplus.demo.dao.UserDao;
import com.psfd.mybatisplus.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author LuYang
 * @create 2020-07-03 16:11
 */
@Service
@Transactional
public class UserServiceimpl extends ServiceImpl<UserDao, UserEntity> implements IUserService {

}
