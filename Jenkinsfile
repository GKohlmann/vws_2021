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
                sh 'make check || true' 
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
