package com.example.awsec2instance.services;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import org.springframework.stereotype.Service;
@Service
public class AWSservice {
    public String createEC2Instance(AWSCredentials awsCredentials) {
        // Set up your AWS credentials
        BasicAWSCredentials credentials = new BasicAWSCredentials(awsCredentials.getAWSAccessKeyId(), awsCredentials.getAWSSecretKey());

        // Set up the Amazon EC2 client
        AmazonEC2 ec2Client = AmazonEC2ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion("ca-central-1")
                .build();

        // Set up the request to run the EC2 instance
        RunInstancesRequest runInstancesRequest = new RunInstancesRequest()
                .withImageId("ami-0a2e7efb4257c0907")
                .withInstanceType(InstanceType.T2Micro)
                .withMaxCount(1)
                .withMinCount(1)
                .withKeyName("2024key");

        // Run the EC2 instance
        RunInstancesResult runInstancesResult = ec2Client.runInstances(runInstancesRequest);

        // Get information about the newly created instance
        String instanceId = runInstancesResult.getReservation().getInstances().get(0).getInstanceId();
        return "EC2 instance created with ID: " + instanceId;
    }
}
