pipeline {
    agent any

    environment {
        // Define environment variables
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
        ALLURE_RESULTS_DIR = "target/allure-results"
        ALLURE_REPORT_DIR = "target/allure-report"
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo "Checking out code from Git repository"
                checkout scm
            }
        }

        stage('Setup Environment') {
            steps {
                echo "Setting up the environment"
                script {
                    // Clean workspace to avoid conflicts
                    cleanWs()
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                echo "Installing Maven dependencies"
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running tests and generating Cucumber JSON report"
                sh 'mvn test -Dcucumber.plugin="json:target/cucumber.json,html:target/cucumber-html-report"'
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo "Generating Allure results"
                sh """
                   allure generate ${ALLURE_RESULTS_DIR} -o ${ALLURE_REPORT_DIR} --clean
                """
            }
        }

        stage('Publish Reports') {
            steps {
                echo "Publishing reports"
                
                // Publish Cucumber Report
                cucumber(
                    buildStatus: 'UNSTABLE',
                    reportTitle: 'Cucumber Report',
                    jsonReportDirectory: 'target',
                    fileIncludePattern: '**/cucumber.json' // Add this parameter
                )

                // Publish Allure Report
                allure([
                    includeProperties: false,
                    jdk: '',
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: "${ALLURE_RESULTS_DIR}"]]
                ])
            }
        }
    }

    post {
        always {
            echo "Pipeline completed. Cleaning up workspace."
            cleanWs()
        }
        success {
            echo "Build and tests succeeded."
        }
        failure {
            echo "Build or tests failed."
        }
    }
}
