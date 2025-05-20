package com.zeroone.star.cpp.controller;


import cn.hutool.core.bean.BeanUtil;
import com.zeroone.star.cpp.service.ISampleService;
import com.zeroone.star.project.cpp.SampleApis;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.cpp.SampleDTO;
import com.zeroone.star.project.query.cpp.SampleQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 演示示例表 前端控制器
 * </p>
 * @author 阿伟
 * @since 2025-05-11
 */
@RestController
@RequestMapping("/cpp")
public class SampleController implements SampleApis {

    @Resource
    ISampleService service;

    @GetMapping("/query")
    @ApiOperation(value = "分页查询")
    @Override
    public JsonVO<PageDTO<SampleDTO>> queryAll(SampleQuery condition) {
        return service.listAll(BeanUtil.beanToMap(condition, false, true));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加示例")
    @Override
    public JsonVO<String> addData(SampleDTO dto) {
        return service.saveData(dto);
    }

    @PutMapping("/modify")
    @ApiOperation(value = "修改示例")
    @Override
    public JsonVO<String> modifyData(SampleDTO dto) {
        return service.modifyData(dto);
    }

    @PutMapping("/remove")
    @ApiOperation(value = "修改示例")
    @Override
    public JsonVO<String> removeData(String id) {
        ArrayList<String> ids = new ArrayList<>();
        ids.add(id);
        JsonVO<List<String>> listJsonVO = service.removeData(ids);
        if (listJsonVO.getData().isEmpty()) {
            return JsonVO.fail(null);
        }
        return JsonVO.success(listJsonVO.getData().get(0));
    }
}

