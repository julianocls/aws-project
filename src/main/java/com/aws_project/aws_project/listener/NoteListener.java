package com.aws_project.aws_project.listener;

import com.aws_project.aws_project.exception.BusinessException;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NoteListener {

    @SqsListener("${cloud.aws.sqs.aws-project-note-queue}")
    public void noteListener(String message) {

        log.info("Received message from SQS: {}", message);

        try {
            // Simulate message processing (replace with actual logic)
            if (message.contains("fail")) {
                throw new BusinessException("Simulated processing failure");
            }
            log.info("Message processed successfully: {}", message);
        } catch (Exception e) {
            log.error("Error processing message: {}", message, e);
        }
    }
}
