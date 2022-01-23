package com.hcl.poc.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Value("${minio.access.name}")
    String accessKey;
    @Value("${minio.access.secret}")
    String accessSecret;
    @Value("${minio.url}")
    String minioUrl;
    @Value("${minio.port}")
    Integer port;
    @Value("${minio.secure}")
    Boolean secure;

    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient =
                MinioClient.builder()
                        .credentials(accessKey, accessSecret)
                        .endpoint(minioUrl,port,secure)
                        .build();
        return minioClient;
    }
}