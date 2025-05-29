package com.example.apptest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.apptest.entity.GrowthDiary;
import com.example.apptest.mapper.GrowthDiaryMapper;
import com.example.apptest.vo.GrowthDiaryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GrowthDiaryServiceImpl extends ServiceImpl<GrowthDiaryMapper, GrowthDiary> implements GrowthDiaryService{

    @Resource
    private GrowthDiaryMapper growthDiaryMapper;

    @Override
    public IPage<GrowthDiaryVo> getPageListByUserId(GrowthDiaryVo growthDiaryVo) {
        IPage<GrowthDiaryVo> pageInfo = new Page<>(growthDiaryVo.getPageNum(), growthDiaryVo.getPageSize());
        List<GrowthDiaryVo> list = growthDiaryMapper.getPageListByUserId(pageInfo, growthDiaryVo);
        pageInfo.setRecords(list);
        pageInfo.setTotal(list.size());
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(GrowthDiary growthDiary) {
        GrowthDiary diary = new GrowthDiary();
        diary.setUserId(growthDiary.getUserId());
        diary.setTitle(growthDiary.getTitle());
        diary.setContent(growthDiary.getContent());
        diary.setEmotion(growthDiary.getEmotion());
        diary.setCreatedAt(LocalDateTime.now());
        growthDiaryMapper.insert(diary);
    }

}
