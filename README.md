# EC2 Instance Creation API

This API allows you to create an Amazon EC2 instance programmatically using AWS credentials provided in the request body.

## API Endpoints

### Create EC2 Instance
Note: This API create real resources in your AWS account.

- **URL:** `POST /api/ec2/create`

- **Description:** Creates an Amazon EC2 instance using the provided AWS credentials.

- **Request Body:**
  
  ```json
  {
      "accessKey": "YOUR_AWS_ACCESS_KEY",
      "secretKey": "YOUR_AWS_SECRET_KEY"
  }
