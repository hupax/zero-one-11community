package com.zeroone.star.sample.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.sample.entity.Sample;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 演示示
例表 服务类
 * </p>
 *
 * @author zhirepan
 * @since 2025-05-19
 */
public interface ISampleService extends IService<Sample> {
    
    PageDTO<SampleDTO> listAll(SampleQuery query);
    
    SampleDTO getById(String id);
}
