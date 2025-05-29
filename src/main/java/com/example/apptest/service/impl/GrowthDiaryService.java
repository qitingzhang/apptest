package com.example.apptest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.apptest.entity.GrowthDiary;
import com.example.apptest.vo.GrowthDiaryVo;

public interface GrowthDiaryService extends IService<GrowthDiary> {


    IPage<GrowthDiaryVo> getPageListByUserId(GrowthDiaryVo growthDiaryVo);

    void add(GrowthDiary growthDiary);
}
