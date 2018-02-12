package com.ballistic.barco.util;

import com.ballistic.barco.domain.auth.Authority;
import com.ballistic.barco.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.mobile.device.Device;

/**
 * Created by Nabeel on 1/17/2018.
 */
@Component
public class BuiltInUtill {

    @Autowired
    private AuthorityRepository authorityRepository;
    private String[] authoritys;

    public BuiltInUtill() {}

    public String[] getAuthoritys() {
        Integer i = 0;
        for (Authority authority: this.authorityRepository.findAll()) {
            authoritys[i++] = authority.getName();
        }
        return authoritys;
    }


    public static Long getProcessTime() {
        return System.currentTimeMillis();
    }


    static final String AUDIENCE_UNKNOWN = "unknown";
    static final String AUDIENCE_WEB = "web";
    static final String AUDIENCE_MOBILE = "mobile";
    static final String AUDIENCE_TABLET = "tablet";


    private static String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }
        return audience;
    }

}
