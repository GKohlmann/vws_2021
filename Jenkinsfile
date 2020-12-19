pipeline { 
    agent any 

    stages {
        stage('build') {
            steps {
                bat 'set'
            }
        }
        stage('Test'){
            steps {
                junit '**/target/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                sh 'make publish'
            }
        }
    }
}
