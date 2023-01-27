pipeline {

  environment {
    GIT_BRANCH_NAME = "${sh(script:'echo ${GIT_BRANCH##*/}', returnStdout: true).trim()}"
  }
  agent any

  stages {
    stage('Deploy') {
     environment {
         gcs = "${sh(script:/"echo -n ${GIT_BRANCH_NAME,,}-${GIT_COMMIT:0:8}/", returnStdout: true).trim()}"
     }
      steps {
      echo "$gcs"
//         step([$class: "AWSEBDeploymentBuilder",
//           credentialId: "aws",
//           awsRegion: "us-east-1",
//           applicationName: "boot-2",
//           environmentName: "Boot-2-env",
//           rootObject: ".",
//           includes: "**/*",
//           excludes: "",
//           bucketName: "elasticbeanstalk-us-east-1-335298206423",
//           keyPrefix: "docker",
//           sleepTime: "10",
//           checkHealth: "true",
//           maxAttempts: "13",
//           versionLabelFormat: "34",
//           versionDescriptionFormat: "${345}",
//         ])
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