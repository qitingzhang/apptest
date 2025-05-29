package com.example.apptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.apptest.entity.GrowthDiary;
import com.example.apptest.vo.GrowthDiaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface GrowthDiaryMapper extends BaseMapper<GrowthDiary> {

    List<GrowthDiaryVo> getPageListByUserId(IPage<GrowthDiaryVo> pageInfo, @Param("query") GrowthDiaryVo growthDiaryVo);



}
