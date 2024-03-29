package com.vegetablechicken.plantrecognition.controller;

import com.vegetablechicken.plantrecognition.entity.Like;
import com.vegetablechicken.plantrecognition.request.LikeRequest;
import com.vegetablechicken.plantrecognition.response.ReducePlantsResponse;
import com.vegetablechicken.plantrecognition.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api("喜欢")
@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/insertLike")
    @ApiOperation(value = "添加喜欢", notes = "添加喜欢", tags = "Like",httpMethod = "POST")
    public String insertLike(@RequestBody LikeRequest likeRequest){

        return likeService.insertLike(likeRequest.getEmail(),likeRequest.getPid());
    }

    @PostMapping("/deleteLike")
    @ApiOperation(value = "删除喜欢", notes = "删除喜欢", tags = "Like",httpMethod = "POST")
    public void deleteLike(@RequestBody LikeRequest likeRequest){

        likeService.deleteLike(likeRequest.getEmail(),likeRequest.getPid());
    }

    @GetMapping("/getLikes")
    @ApiOperation(value = "获得喜欢的植物列表", notes = "获得一个用户所有喜欢的植物的简略信息", tags = "Like",httpMethod = "GET")
    public List<ReducePlantsResponse> getLikes(@RequestParam String email){
        return likeService.getLikePlants(email);
    }


}
