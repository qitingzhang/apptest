package com.example.apptest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.apptest.entity.GrowthDiary;
import com.example.apptest.vo.GrowthDiaryVo;

public interface GrowthDiaryService extends IService<GrowthDiary> {

    /**
     * 根据UserId分页查询
     * @param growthDiaryVo
     * @return
     */
    IPage<GrowthDiaryVo> getPageListByUserId(GrowthDiaryVo growthDiaryVo);

    /**
     * 添加接口
     * @param growthDiary
     */
    void add(GrowthDiary growthDiary);
}
