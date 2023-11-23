pipeline{
    agent any
    options{
        buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '5'))
        timestamps()
    }
    environment{
        registry = "lurubino/test-repotest"
        registryCredential = 'dockerhub'
        KUBECONFIG = credentials('kubeconfig')
    }
    stages{
        stage('Initialize'){
            steps{
                script{
                    def dockerHome = tool 'docker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                }
            }
        }
        stage('Building image') {
            steps{
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
        stage('Deploy Image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploying java test container to Kubernetes') {
            steps {
                script {
                    sh 'curl -LO "https://storage.googleapis.com/kubernetes-release/release/v1.20.5/bin/linux/amd64/kubectl"'
                    sh 'chmod u+x ./kubectl'
                    sh "kubectl apply -f deployment.yaml --kubeconfig=\$KUBECONFIG"
                    sh 'kubectl apply -f service.yaml --kubeconfig=$KUBECONFIG'
                }
            }
        }
    }
}
