package com.ballistic.barco.captcha.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nabeel on 1/22/2018.
 */
@Service("reCaptchaAttemptService")
public class ReCaptchaAttemptService {

    private final static Logger log = LoggerFactory.getLogger(ReCaptchaAttemptService.class);

    private final Integer MAX_ATTEMPT = 4;
    private LoadingCache<String, Integer> attemptsCache;

    public ReCaptchaAttemptService() {
        super();
        log.info("Start Attempt Service.....");
        attemptsCache = CacheBuilder.newBuilder().
            expireAfterWrite(4, TimeUnit.HOURS).build(new CacheLoader<String, Integer>() {
                @Override
                public Integer load(final String key) {
                    return 0;
                }
        });
    }

    public void reCaptchaSucceeded(final String key) { attemptsCache.invalidate(key); }
    public void reCaptchaFailed(final String key) {
        int attempts = attemptsCache.getUnchecked(key);
        attempts++;
        attemptsCache.put(key, attempts);
    }
    public boolean isBlocked(final String key) { return attemptsCache.getUnchecked(key) >= MAX_ATTEMPT; }
}