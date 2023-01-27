pipeline {

  environment {
    jk_aws_id = '<JENKINS_AWS_CREDENTIAL_ID>'
    GIT_BRANCH_NAME = "${sh(script:'echo ${GIT_BRANCH##*/}', returnStdout: true).trim()}"
  }
  agent any

  stages {
    stage('Deploy') {
     environment {
          gcs = "${sh(script:'echo -n ${GIT_BRANCH_NAME,,}-${GIT_COMMIT:0:8}', returnStdout: true).trim()}"
     }
     when {
          anyOf {
            branch 'develop';
            branch 'master'
          }
     }
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
               versionLabelFormat: "$gcs",
               versionDescriptionFormat: "$gcs",
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