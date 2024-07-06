pipeline {
    agent any

    environment {
        SONARQUBE_URL = 'http://your-sonarqube-server:9000'
        SONARQUBE_CREDENTIALS = 'sonarqube-credentials-id'
        ALLURE_RESULTS_DIRECTORY = 'allure-results'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/KareemZafan/procode-selenium.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Execute the build process
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Start Selenium Grid') {
            steps {
                script {
                    // Start Docker Compose for Selenium Grid
                    sh 'docker-compose -f docker-compose.yaml up -d --scale chrome=2 --scale firefox=2 '
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run TestNG tests
                    sh 'mvn -DxmlFile=testng.xml test'
                }
            }
        }

        stage('SonarQube Analysis') {
            environment {
                scannerHome = tool 'SonarQubeScanner'
            }
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }

        stage('Allure Report') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        results: [[path: ALLURE_RESULTS_DIRECTORY]]
                    ])
                }
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                script {
                    // Stop Docker Compose for Selenium Grid
                    sh 'docker-compose -f docker-compose.yaml down'
                }
            }
        }
    }

    post {
        always {
            script {
                // Archive the test results and reports
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}