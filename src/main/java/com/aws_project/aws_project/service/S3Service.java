package com.aws_project.aws_project.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
public class S3Service {

    private static final Logger log = LoggerFactory.getLogger(S3Service.class);
    private final S3Client s3Client;
    private final SqsService sqsService;

    public void upload(String bucketName, String key, String content) {

        var putObjet = PutObjectRequest.builder().bucket(bucketName).key(key).build();
        var requestBody = RequestBody.fromString(content);

        s3Client.putObject(putObjet, requestBody);

        log.info("File upload uploaded. File={}", key);

        var message = "{\"message=" + content + ", \"fileName:"+key+"}";
        sqsService.publishMessage(message);
    }

}
