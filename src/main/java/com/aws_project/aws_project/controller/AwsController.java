package com.aws_project.aws_project.controller;

import com.aws_project.aws_project.configuration.propeties.AwsProperties;
import com.aws_project.aws_project.controller.request.RequestNote;
import com.aws_project.aws_project.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aws/s3")
public class AwsController {

    private final S3Service s3Service;
    private final AwsProperties awsProperties;

    @PostMapping("/note")
    public void note(@RequestBody @Validated RequestNote requestNote) {

        var bucketName = awsProperties.getS3().getBucketName();
        s3Service.upload(bucketName, requestNote.getName(), requestNote.getContent());

    }

}
