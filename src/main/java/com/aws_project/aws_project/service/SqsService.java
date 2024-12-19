package com.aws_project.aws_project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class SqsService {

    @Value("${cloud.aws.sqs.aws-project-note-queue}")
    private String noteQueueUrl;

    private final SqsClient sqsClient;

    public void publishMessage(String message) {
        log.info("Publishing message to SQS: {}", message);

        try {
            sqsClient.sendMessage(SendMessageRequest.builder()
                    .messageBody(message)
                    .queueUrl(noteQueueUrl)
                    .build());
            log.info("Message successfully published to SQS: {}", message);
        } catch (Exception e) {
            log.error("Failed to publish message to SQS: {}", message, e);
            throw e;
        }
    }

}
