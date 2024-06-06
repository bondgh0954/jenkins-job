def buildJar(){
    echo "building application artifact"
    sh "mvn package"

}

def buildImage(){
    echo "building application into docker image"
    withCredentials([usernamePassword(credentialsId: "dockerhub-credentials",usernameVariable: "USERNAME", passwordVariable:"PASSWORD")]){
        sh 'docker build -t nanaot/java-app:6.0 .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        sh 'docker push nanaot/java-app:6.0'
    }


}
    