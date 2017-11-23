package com.ax.service.service.apiinterface.impl;

import com.ax.service.daomain.AchievementDyyDetailsMapper;
import com.ax.service.model.po.AchievementDyyDetails;
import com.ax.service.service.apiinterface.TestI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSer implements TestI {

    @Autowired
    AchievementDyyDetailsMapper achievementDyyDetailsMapper;

    @Override
    public PageInfo bb() {
        PageHelper.startPage(1,20);
        List<AchievementDyyDetails> achievementDyyDetails =  achievementDyyDetailsMapper.selectAll();

        return new PageInfo(achievementDyyDetails);
    }
}
