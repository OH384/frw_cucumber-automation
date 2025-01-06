pipeline {
     agent any

     tools {
         maven 'Maven 3.9.9' // Ensure Maven is installed and configured in
Jenkins
         jdk 'JDK 17'     
     }

     environment {
         ALLURE_RESULTS = 'target/allure-results'
results
     }

     stages {
         stage('Checkout') {
             steps {
                 checkout scm
             }
         }

         stage('Install Dependencies') {
             steps {
                 sh 'mvn clean install -DskipTests' 
             }
         }

         stage('Run Tests & Generate Allure Report') {
             steps {
                 sh '''
                     mvn test -Dsurefire.useFile=false
-Dallure.results.directory=${ALLURE_RESULTS}
                     echo "Contents of allure-results:"
                     ls -la ${ALLURE_RESULTS}
                 '''
             }
         }

         stage('Archive Artifacts') {
             steps {
                 archiveArtifacts artifacts: '${ALLURE_RESULTS}/**',
allowEmptyArchive: true
             }
         }
     }

     post {
         always {
             script {
                 allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: "${ALLURE_RESULTS}"]]
                 ])
             }
         }
     }
}
