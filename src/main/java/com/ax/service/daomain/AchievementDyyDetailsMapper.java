package com.ax.service.daomain;

import com.ax.service.model.po.AchievementDyyDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementDyyDetailsMapper {
    int insert(AchievementDyyDetails record);

    List<AchievementDyyDetails> selectAll();
}