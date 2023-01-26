pipeline {
    agent docker

    stages {
        stage('Build') {
            steps {
              sh 'docker build .'          }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}