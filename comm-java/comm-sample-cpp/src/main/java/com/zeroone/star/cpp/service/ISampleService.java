package com.zeroone.star.cpp.service;

import com.zeroone.star.cpp.config.FeignConfiguration;
import com.zeroone.star.cpp.fallback.CppServiceFallBack;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.cpp.SampleDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 演示示例表 服务类
 * </p>
 * @author 阿伟
 * @since 2025-05-11
 */
@FeignClient(
        name = "${cpp.sample.name}",
        url = "${cpp.sample.url}",
        fallbackFactory = CppServiceFallBack.class,
        configuration = FeignConfiguration.class
)
public interface ISampleService {

    /**
     * 分页查询
     * @param condition 查询条件
     * @return 查询结果
     */
    @GetMapping("/sample")
    JsonVO<PageDTO<SampleDTO>> listAll(@RequestParam Map<String, Object> condition);

    /**
     * 添加数据
     * @param dto 数据传输对象
     * @return 添加结果
     */
    @PostMapping("/sample")
    JsonVO<String> saveData(@RequestBody SampleDTO dto);

    /**
     * 修改数据
     * @param dto 数据传输对象
     * @return 修改结果
     */
    @PutMapping("/sample")
    JsonVO<String> modifyData(@RequestBody SampleDTO dto);

    /**
     * 删除数据
     * @param ids 删除的id
     * @return 删除结果
     */
    @DeleteMapping("/sample")
    JsonVO<List<String>> removeData(@RequestBody List<String> ids);
}
