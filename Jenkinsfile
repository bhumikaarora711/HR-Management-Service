pipeline {
    agent any

    stages {
         stage('Maven Instatllation') {
            steps {
                echo 'Building the checked out project'
            }
        }
        stage('Build') {
            steps {
                echo 'building application'
            }
        }
          stage('test') {
            steps {
                echo 'testing application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'deploying application'
            }
        }
    }
}