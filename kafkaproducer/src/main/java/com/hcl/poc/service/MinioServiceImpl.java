package com.hcl.poc.service;

import com.hcl.poc.utils.ServiceUtils;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
public class MinioServiceImpl implements MinioService{

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private ServiceUtils serviceUtils;

    @Value("${minio.bucket.name}")
    String configuredBucketName;
    @Value("${minio.file-size}")
    Long fileSize;
    @Value("${minio.url}")
    String minioUrl;
    @Value("${file.name}")
    String fileName;

    @Override
    @SneakyThrows
    public boolean bucketExists(String bucketName) {
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (found) {
            System.out.println(bucketName + " exists");
        } else {
            System.out.println(bucketName + " does not exist");
        }
        return found;
    }

    @Override
    @SneakyThrows
    public void makeBucket(String bucketName) {
        boolean flag = bucketExists(bucketName);
        if (!flag) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build());
        } else {
            System.out.println("Bucket exists !!!");
        }
    }

    @Override
    public String upload(String bucketName) {
        try {
            // Bucket check
            bucketName = StringUtils.isNotBlank(bucketName) ? bucketName : configuredBucketName;
            if (!this.bucketExists(bucketName)) {
                this.makeBucket(bucketName);
            }

            // Getting file
            //File file = new File(this.getClass().getClassLoader().getResource(fileName).getFile());

            // generating a random file with random content
            File file= serviceUtils.generateRandomFile(fileName);

            // Creating inputStream
            InputStream inputStream = new FileInputStream(file);

            // file name
            String fileName = file.getName();

            // creating an object name to store in bucket
            String objectName = UUID.randomUUID().toString().replaceAll("-", "")
                    + fileName.substring(fileName.lastIndexOf("."));

            // Minio client method to upload the file
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
                                    inputStream, -1, fileSize)
                            .contentType("text/plain")
                            .build());

            return minioUrl+"/"+bucketName+"/"+objectName;
        } catch (Exception e) {
            e.printStackTrace();
            return " Upload failed ";
        }
    }
}
