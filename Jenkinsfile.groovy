pipeline {
    agent {
        docker {
            image 'maven:3.9.1-eclipse-temurin-17' // customize for your project
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    environment {
        GIT_REPO = 'https://github.com/SriSaiKrishnan/framework.git'
    }

    stages {
        stage('Checkout') {
            steps {
                git "${env.GIT_REPO}"
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
