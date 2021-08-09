package org.demon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class FileController {

    @PostMapping("upload")
    public Map<String, Object> upload(@RequestPart("headerImg") MultipartFile headerImg,
                                      @RequestPart("wallpapers") MultipartFile[] wallpapers) throws IOException {
        Map<String, Object> result = new HashMap<>();

        log.info("headerImg = {}, wallpapers = {}", headerImg.getSize(), wallpapers.length);

        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\cache\\header\\" + originalFilename));
        }

        if(wallpapers.length > 0){
            for (MultipartFile wallpaper : wallpapers) {
                if(!wallpaper.isEmpty()){
                    String originalFilename = wallpaper.getOriginalFilename();
                    wallpaper.transferTo(new File("E:\\cache\\wallpaper" + originalFilename));
                }
            }
        }

        result.put("headerImgSize", headerImg.getSize());
        result.put("wallpaperNum", wallpapers.length);
        return result;
    }

}
