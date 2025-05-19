package com.zeroone.star.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.sample.entity.Sample;
import com.zeroone.star.sample.mapper.SampleMapper;
import com.zeroone.star.sample.service.ISampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 演示示
例表 服务实现类
 * </p>
 *
 * @author zhirepan
 * @since 2025-05-19
 */
@Service
public class SampleServiceImpl extends ServiceImpl<SampleMapper, Sample> implements ISampleService {
    
    @Resource
    MsSampleMapper ms;
    
    @Override
    public PageDTO<SampleDTO> listAll(SampleQuery query) {
        // 构建分页查询对象
        Page<Sample> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<Sample> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(query.getName()), "name", query.getName());
        wrapper.orderBy(true, false, "IFNULL('update_time', 'create_time')");
        wrapper.orderBy(true, false, "id");
        // 查询结果
        Page<Sample> pageResult = baseMapper.selectPage(page, wrapper);
        return PageDTO.create(pageResult, src -> ms.sampletoDTO(src));
    }
    
    @Override
    public SampleDTO getById(String id) {
        Sample sample = baseMapper.selectById(id);
        if (sample != null) {
            return ms.sampletoDTO(sample);
        }
        return null;
    }
}
