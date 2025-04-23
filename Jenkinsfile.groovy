pipeline {
    agent any

    environment {
        GIT_REPO = 'https://github.com/SriSaiKrishnan/framework.git'
    }

    stages {
        stage('Build in Docker') {
            steps {
                script {
                    docker.image('maven:3.9.1-eclipse-temurin-17').inside('-v /var/run/docker.sock:/var/run/docker.sock') {
                        sh "git clone ${env.GIT_REPO} repo"
                        dir('repo') {
                            sh 'mvn clean test'
                        }
                    }
                }
            }
        }
    }

}
