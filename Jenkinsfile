pipeline {
    agent any
    tools {
        jdk 'jdk'
        maven '3.8.3'
       
    }
    stages {
        stage("build project") {
            steps {
               // git 'https://github.com/adanisman/MyTraderAPI.git'
                echo "Java VERSION"
                sh 'java -version'
                echo "Maven VERSION"
                sh 'mvn -version'
                echo 'building project...'
                sh "mvn compile"
                sh "mvn package"
                sh "mvn clean install"
            }
        }
    }
}