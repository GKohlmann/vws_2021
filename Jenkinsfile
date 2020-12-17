pipeline {
    agent any
    
    tools {
        maven 'M3'
    }

    stages {
    	stage('Checkout') {
            steps {
                git 'https://github.com/GKohlmann/vws_2021'
            }
        }
    
        stage('Build') {
            steps {
                sh 'mvn -B package'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'make check || true' 
                junit '**/target/*.xml' 
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                echo 'Deploying....'
                sh 'make publish'
            }
        }
    }
}
