package com.ballistic.barco.service.qr_code;

import org.slf4j.*;
import com.google.zxing.WriterException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.IOException;

/**
 * Created by Nabeel on 1/11/2018.
 */
@Service
@Cacheable(cacheNames = "qr-code-cache", sync = true)
public class QrCodeServiceImpl implements IQrCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QrCodeServiceImpl.class);

    @Override
    public byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException {
        return new byte[0];
    }

    @Async
    @Override
    public ListenableFuture<byte[]> generateQRCodeAsync(String text, int width, int height) throws Exception {
        return null;
    }

    @Override
    @CacheEvict(cacheNames = "qr-code-cache", allEntries = true)
    public void purgeCache() {
        LOGGER.info("Purging cache");
    }
}
