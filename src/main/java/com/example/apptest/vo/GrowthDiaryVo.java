package com.example.apptest.vo;

import com.example.apptest.entity.GrowthDiary;
import lombok.Data;

@Data
public class GrowthDiaryVo extends GrowthDiary {

    private Integer pageNum;

    private Integer pageSize;
}
