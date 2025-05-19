package com.zeroone.star.sample.service.impl;


import com.zeroone.star.project.dto.sample.SampleAddDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.sample.entity.Sample;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MsSampleMapper {
    /**
     * 将实体类转换为DTO
     * @param entity
     * @return
     */
    SampleDTO sampletoDTO(Sample sdo);
    
    /**
     * 将 Add DTO 转为实体类
     * @param dto
     * @return
     */
    Sample addDtoToDo(SampleAddDTO dto);
    
    /**
     * 将DTO转为实体类DO
     * @param dto
     * @return
     */
    Sample dtoTodo(SampleDTO dto);
}
