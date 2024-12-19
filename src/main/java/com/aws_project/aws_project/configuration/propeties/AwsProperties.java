package com.aws_project.aws_project.configuration.propeties;

import com.aws_project.aws_project.configuration.propeties.aws.S3;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {
    private S3 s3;
}

