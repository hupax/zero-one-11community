package com.zeroone.star.sample.controller;


import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleAddDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.project.sample.SampleApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sample.entity.Sample;
import com.zeroone.star.sample.service.ISampleService;
import com.zeroone.star.sample.service.impl.MsSampleMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 演示示
例表 前端控制器
 * </p>
 *
 * @author zhirepan
 * @since 2025-05-19
 */
@RestController
@RequestMapping("/sample")
@Validated
public class SampleController implements SampleApis {
    // 呼叫service
    @Resource
    ISampleService service;
    
    @Resource
    MsSampleMapper ms;
    
    @PostMapping("/add-sample")
    @ApiOperation(value = "添加示例")
    @Override
    public JsonVO<String> addSample(@Validated @RequestBody SampleAddDTO addDto) {
        Sample sample = ms.addDtoToDo(addDto);
        if (service.save(sample)) {
            return JsonVO.success(sample.getId());
        }
        return JsonVO.fail(null);
    }
    
    @PutMapping("/modify-sample")
    @ApiOperation(value = "修改示例")
    @Override
    public JsonVO<String> modifySample(@Validated @RequestBody SampleDTO dto) {
        if (service.updateById(ms.dtoTodo(dto))) {
            return JsonVO.success(dto.getId());
        }
        return JsonVO.fail(null);
    }
    
    @GetMapping("/query-all")
    @ApiOperation(value = "分页查询示例")
    @Override
    public JsonVO<PageDTO<SampleDTO>> queryAll(@Validated SampleQuery condition) {
        return JsonVO.success(service.listAll(condition));
    }
    
    @GetMapping("/query-one")
    @ApiOperation(value = "编号查询")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "11")
    @Override
    public JsonVO<SampleDTO> queryById(String id) {
        return JsonVO.success(service.getById(id));
    }
}

