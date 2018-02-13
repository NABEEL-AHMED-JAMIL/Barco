package com.ballistic.barco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.ballistic.barco.util.ContentPathUtil.*;

/**
 * Created by Nabeel on 1/11/2018.
 */
@RestController
@RequestMapping(QR_CODE)
public class QrCodeController {

    public String returnString = "{\"success\": true,   \"payload\": \"{}!\", " + "}";

    @RequestMapping(value = GENERATE_QR, method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public ResponseEntity<String> setQr_Code() {
        return new ResponseEntity<String>(String.format(returnString, "GENERATE_QR"), HttpStatus.OK);
    }

    @RequestMapping(value = DECODE_QR, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> getDecode_Qr() {
        return new ResponseEntity<String>(String.format(returnString, "DECODE_QR"), HttpStatus.OK);
    }

}
