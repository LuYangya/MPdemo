package com.psfd.mybatisplus.demo.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.mybatisplus.demo.bean.Job;
import com.psfd.mybatisplus.demo.dao.JobDao;
import com.psfd.mybatisplus.demo.service.IJobService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @author LuYang
 * @create 2020-07-03 16:11
 */
@Service
@Transactional
public class JobServiceimpl extends ServiceImpl<JobDao,Job> implements IJobService {


}
