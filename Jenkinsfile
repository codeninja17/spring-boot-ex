pipeline {
  agent any

  stages {
    stage('Deploy') {
      steps {
        step([$class: 'AWSEBDeploymentBuilder',
               credentialId: 'aws-cred',
               awsRegion: 'us-east-1',
               applicationName: 'boot',
               environmentName: 'Boot-env',
               rootObject: '.',
               includes: '**/*',
               excludes: '',
               bucketName: 'elasticbeanstalk-us-east-1-335298206423',
               keyPrefix: 'docker',
               sleepTime: '10',
               checkHealth: 'true',
               maxAttempts: '12'])
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