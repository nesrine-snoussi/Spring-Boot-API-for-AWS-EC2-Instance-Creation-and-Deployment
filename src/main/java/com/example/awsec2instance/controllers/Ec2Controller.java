package com.example.awsec2instance.controllers;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.example.awsec2instance.entities.AWSCredentialsDTO;
import com.example.awsec2instance.services.AWSservice;
import org.apache.http.auth.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ec2")
public class Ec2Controller {
    private final AWSservice ec2Service;

    @Autowired
    public Ec2Controller(AWSservice ec2Service) {
        this.ec2Service = ec2Service;
    }

    @PostMapping("/create")
    public String createEC2Instance(@RequestBody AWSCredentialsDTO credentials) {
        AWSCredentials awsCredentials = new BasicAWSCredentials(credentials.getAccessKey(), credentials.getSecretKey());
        return ec2Service.createEC2Instance(awsCredentials);
    }
}
