package com.psfd.mybatisplus.demo.controller;

import com.psfd.mybatisplus.demo.bean.Job;
import com.psfd.mybatisplus.demo.service.IJobService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * @author LuYang
 * @create 2020-07-06 16:03
 */
@Controller
@RequestMapping("/job")
public class JobController {
    @Resource
    public IJobService iJobService;

    @RequestMapping("/joblist")
    public ModelAndView getlist(int id){
        List<Job> list = iJobService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("joblist",list);
        modelAndView.addObject("isstock",id);
        modelAndView.setViewName("job/listjob");
        return modelAndView;
    }

    @RequestMapping("/editjob")
    public ModelAndView editjob(int id){
        List<Job> list = iJobService.list();
        Job j = new Job();
        for (Job job : list) {
            if(job.getId() == id){
               j = job;
            }
        }
        j.setIsstock((byte)1);
        iJobService.updateById(j);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("joblist",list);
        modelAndView.setViewName("job/listjob");
        return modelAndView;
    }






    @RequestMapping("/jobadd")
    public ModelAndView jobadd(Job job){
        Date date = new Date(System.currentTimeMillis());
        job.setCreatetime(date);
        job.setIsstock((byte) 0);
        System.out.println(job.toString());
        iJobService.save(job);
        List<Job> list = iJobService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("joblist",list);
        modelAndView.setViewName("job/listjob");
        return modelAndView;
    }


    @RequestMapping("/removejob")
    public ModelAndView remove(int id){
        iJobService.removeById(id);
        List<Job> list = iJobService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("joblist",list);
        modelAndView.setViewName("job/listjob");
        return modelAndView;
    }

    @RequestMapping("/detailjob")
    public ModelAndView detailjob(int id){
          ModelAndView m = new ModelAndView();
          m.addObject("job",iJobService.getById(id));
          m.setViewName("job/detailjob");
        return m;
    }
}
