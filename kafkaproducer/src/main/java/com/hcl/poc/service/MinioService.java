package com.hcl.poc.service;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {
    /**
     *  Judge  bucket Whether there is
     *  @param bucketName
     *  @return
     */
    boolean bucketExists(String bucketName);
    /**
     *  establish  bucket
     *  @param bucketName
     */
    void makeBucket(String bucketName);
    /**
     *  Upload files
     *  @param bucketName
     */
    String upload(String bucketName);
}
