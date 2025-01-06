pipeline {
    agent any
    environment {
        ALLURE_RESULTS = 'target/allure-results'
        CUCUMBER_RESULTS = 'target/cucumber.json' // Définir le chemin du rapport Cucumber
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

        stage('Run Tests & Generate Reports') {
            steps {
                sh '''
                    mvn test -Dsurefire.useFile=false -Dallure.results.directory=${ALLURE_RESULTS} -Dcucumber.options="--plugin json:${CUCUMBER_RESULTS}"
                    echo "Contents of allure-results:"
                    ls -la ${ALLURE_RESULTS}
                    echo "Contents of cucumber-report:"
                    ls -la ${CUCUMBER_RESULTS}
                '''
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '${ALLURE_RESULTS}/**', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            script {
                // Publier le rapport Allure
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: "${ALLURE_RESULTS}"]]
                ])

                // Publier le rapport Cucumber
                publishCucumberReports([
                    jsonReport: "${CUCUMBER_RESULTS}",
                    reportName: "Cucumber Report"
                ])
            }
        }
    }
}
