package com.example.apptest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.apptest.common.Result;
import com.example.apptest.entity.GrowthDiary;
import com.example.apptest.service.impl.GrowthDiaryService;
import com.example.apptest.vo.GrowthDiaryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/diary")
@Api(value = "成长日记", tags = {"成长日记"})
public class GrowthDiaryController {

    private static final Logger logger = LoggerFactory.getLogger(GrowthDiaryController.class);

    @Resource
    private GrowthDiaryService growthDiaryService;

    @GetMapping(value = {"/{userId}"})
    @ApiOperation(value = "根据UserId分页查询")
    public Result getPageListByUserId(@PathVariable(value = "userId", required = false) Integer userId,
                                      @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pagesSize) {
        IPage<GrowthDiaryVo> page = growthDiaryService.getPageListByUserId(new GrowthDiaryVo() {{
            setUserId(userId);
            setPageNum(pageNum);
            setPageSize(pagesSize);

        }});
        return Result.ok(page);
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable(value = "id", required = false) Integer id) {
        GrowthDiary growthDiary = growthDiaryService.getById(id);
        return Result.ok(growthDiary);
    }

    @ApiOperation("添加接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id"),
            @ApiImplicitParam(name = "title", value = "标题"),
            @ApiImplicitParam(name = "content", value = "内容"),
            @ApiImplicitParam(name = "emotion", value = "表情")})
    @PostMapping("/add")
    public Result add(@RequestBody GrowthDiary growthDiary) {
        try{
            if(ObjectUtils.isEmpty(growthDiary.getUserId()) || ObjectUtils.isEmpty(growthDiary.getTitle())){
                return Result.fail("用户Id或者标题不能为空！");
            }
            growthDiaryService.add(growthDiary);
            return Result.ok();
        } catch (Exception e){
            logger.error("/diary/add:{}", e.getMessage());
            return Result.fail();
        }
    }

}
