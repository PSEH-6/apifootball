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
            sshagent(['vedant-aws']) {
               sh "ssh -o StrictHostKeyChecking=no ec2-user@ec2-34-211-0-250.us-west-2.compute.amazonaws.com sudo docker run -p 8080:8080 --name apifootball-app vedantkdesai/apifootball:${BUILD_NUMBER}"
            }
         }
      }

   }
}