pipeline {
   agent any

   tools {
      maven "M3"
   }

   stages {
      stage('Build') {
         steps {
            sh "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         post {
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
            }
         }
      }

      stage('Build Docker Image') {
         steps {
            withCredentials([string(credentialsId: 'DockerPassword', variable: 'DockerPwd')]) {
               sh "docker login -u vedantkdesai -p ${DockerPassword}"
            }
            sh "docker build -t vedantkdesai/apifootball:${BUILD_NUMBER} ."
         }
      }

      stage('Push Docker Image') {
         steps {
            withCredentials([string(credentialsId: 'DockerPassword', variable: 'DockerPwd')]) {
               sh "docker login -u vedantkdesai -p ${DockerPassword}"
            }
            sh "docker push vedantkdesai/apifootball:${BUILD_NUMBER}"
         }
      }

   }
}