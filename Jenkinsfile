pipeline { 
    agent any 

    stages {
        stage('build') {
            steps {
                bat 'set'
            }
        }
        stage('test'){
            steps {
                echo 'Test'
            }
        }
        stage('deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                echo 'publish'
            }
        }
    }
}
