pipeline {
  agent any

  stages {
    stage('Deploy') {
      steps {
        echo "${aws-cred}"
        step([$class: 'AWSEBDeploymentBuilder',
          applicationName: 'boot',
          awsRegion: 'us-east-1',
          bucketName: 'elasticbeanstalk-us-east-1-335298206423',
          keyPrefix: 'docker',
          credentialId: "${aws-cred}"
        ])
      }
    }
  }
}

 //         stage('Build') {
 //             steps {
 //               sh 'docker build -t boot:build --target build .'
 //             }
 //         }
 //         stage('Test') {
 //             steps {
 //                  sh 'docker build -t boot:test --target test .'
 //             }
 //         }