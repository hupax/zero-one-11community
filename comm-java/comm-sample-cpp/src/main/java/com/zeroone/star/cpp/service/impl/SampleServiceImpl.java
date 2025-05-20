package com.zeroone.star.cpp.service.impl;

import com.zeroone.star.cpp.service.ISampleService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.cpp.SampleDTO;
import com.zeroone.star.project.vo.JsonVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 演示示例表 服务实现类-降级实现
 * </p>
 * @author 阿伟
 * @since 2025-05-11
 */
@AllArgsConstructor
public class SampleServiceImpl implements ISampleService {

    private final Throwable throwable;

    private <T> JsonVO<T> setMessage(JsonVO<T> vo) {
        if (throwable.getMessage() != null) {
            vo.setMessage(throwable.getMessage());
        } else {
            vo.setMessage(throwable.getClass().toGenericString());
        }
        return vo;
    }

    @Override
    public JsonVO<PageDTO<SampleDTO>> listAll(Map<String, Object> condition) {
        return setMessage(JsonVO.fail(null));
    }

    @Override
    public JsonVO<String> saveData(SampleDTO dto) {
        return setMessage(JsonVO.fail(null));
    }

    @Override
    public JsonVO<String> modifyData(SampleDTO dto) {
        return setMessage(JsonVO.fail(null));
    }

    @Override
    public JsonVO<List<String>> removeData(List<String> ids) {
        return setMessage(JsonVO.fail(null));
    }
}
