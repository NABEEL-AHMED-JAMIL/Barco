package com.ballistic.barco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.ballistic.barco.util.ContentPathUtil.*;

/**
 * Created by Nabeel on 1/16/2018.
 */
@RestController
@RequestMapping(value = SPRITE)
public class ImageSpriteController {


    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(value = IMAGE_SPRITE, method = RequestMethod.POST)
    public ResponseEntity<String> imageSprite() {
        return new ResponseEntity<String>("{image-sprite: image-sprite}", HttpStatus.OK);
    }

    @PreAuthorize("#oauth2.hasScope('write')")
    @RequestMapping(value = IMAGE_JOIN, method = RequestMethod.POST)
    public ResponseEntity<String> imageJoin() {
        return new ResponseEntity<String>("{image-join: image-join}", HttpStatus.OK);
    }
}
