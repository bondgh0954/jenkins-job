pipeline {
   agent any
   tools{
     maven "maven-3.9.7"
   }

   stages{
     

     stage("build jar"){
       steps{
         script{
          echo "building application artifact"
          sh "mvn package"
         }
       }
     }

     stage("build image"){
       steps{
         script{
           echo "building application into docker image"
               withCredentials([usernamePassword(credentialsId: "dockerhub-credentials",usernameVariable: "USERNAME", passwordVariable:"PASSWORD")]){
                   sh 'docker build -t nanaot/java-app:6.0 .'
                   sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
                   sh 'docker push nanaot/java-app:6.0'
               }
         }
       }
     }
   }
}