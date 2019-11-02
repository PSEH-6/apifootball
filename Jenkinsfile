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
            withCredentials([string(credentialsId: 'DockerPwd', variable: 'DockerPassword')]) {
               sh "docker login -u vedantkdesai -p ${DockerPassword}"
            }
            sh "docker build -t vedantkdesai/apifootball:${BUILD_NUMBER} ."
         }
      }

      stage('Push Docker Image') {
         steps {
            withCredentials([string(credentialsId: 'DockerPwd', variable: 'DockerPassword')]) {
               sh "docker login -u vedantkdesai -p ${DockerPassword}"
            }
            sh "docker push vedantkdesai/apifootball:${BUILD_NUMBER}"
         }
      }
      
      stage('Run Container') {
        steps {
            sshagent(['aws-credentials']) {
               sh "ssh -o StrictHostKeyChecking=no ubuntu@13.58.209.5 sudo docker run -p 8080:8080 --name vedant-docker vedantkdesai/apifootball:${BUILD_NUMBER}"
            }

         }
      }

   }
}