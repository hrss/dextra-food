pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /root/.m2:/root/.m2 -v /home/ubuntu:/home/ubuntu'
        }

      }
      steps {
        sh 'pwd'
        sh 'mvn -B -DskipTests clean package'
        sh 'ls'
        stash(name: 'app', includes: 'target/**/*')
        stash(name: 'scripts', includes: 'jenkins/**/*')
      }
    }
    stage('Test') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /root/.m2:/root/.m2'
        }

      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'

        }

      }
      steps {
        sh 'mvn test'
      }
    }
    stage('Build Docker Image') {
      agent any
      steps {
        unstash 'app'
        sh 'docker build -t hrss/dextra-food . '
      }
    }
    stage('Publish') {
      agent any
      steps {
        sh 'docker push hrss/dextra-food'
      }
    }
    stage('Deliver') {
      agent any
      steps {
        unstash 'scripts'
        sh 'jenkins/deliver.sh'
      }
    }
  }
}