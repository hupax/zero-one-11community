package com.zeroone.star.publish.controller;


import com.zeroone.star.project.dto.notify.SampleNotifyDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.publish.comp.RmqPubblish;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 演示示例表 前端控制器
 * </p>
 * @author 阿伟
 * @since 2025-05-11
 */
@RestController
@RequestMapping("/rmq")
public class RmqController {

    @Resource
    RmqPubblish publish;

    @PostMapping("/publish")
    public JsonVO<String> sendMsg(SampleNotifyDTO dto) {
        if (publish.publishNotify(dto)) {
            return JsonVO.success("发送成功");
        }
        return JsonVO.fail("发送失败");
    }
}

