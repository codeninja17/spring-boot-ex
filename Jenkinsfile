pipeline {

  environment {
    GIT_BRANCH_NAME = "${sh(script:'echo ${GIT_BRANCH##*/}', returnStdout: true).trim()}"
  }
  agent any

  stages {
    stage('Deploy') {
     environment {
          GIT_COMMIT = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
     }
      steps {
        step([$class: "AWSEBDeploymentBuilder",
          credentialId: "aws",
          awsRegion: "us-east-1",
          applicationName: "boot-2",
          environmentName: "Boot-2-env",
          rootObject: ".",
          includes: "**/*",
          excludes: "",
          bucketName: "elasticbeanstalk-us-east-1-335298206423",
          keyPrefix: "docker",
          sleepTime: "10",
          checkHealth: "true",
          maxAttempts: "13",
          versionLabelFormat: "$GIT_COMMIT",
          versionDescriptionFormat: "$GIT_COMMIT",
        ])
      }
    }
  }
}

//   stage('Build') {
//       steps {
//         echo "${GIT_BRANCH_NAME}"
//         sh 'docker build -t boot:build --target build .'
//       }
//     }
//     stage('Test') {
//       steps {
//         sh 'docker build -t boot:test --target test .'
//       }
//     }