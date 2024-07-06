pipeline {
    agent any // Use any available agent

    environment {
        SONARQUBE_URL = 'http://your-sonarqube-server:9000'
        SONARQUBE_CREDENTIALS = 'sonarqube-credentials-id'
        ALLURE_RESULTS_DIRECTORY = './allure-results'
        MAVEN_HOME = tool name: 'Maven 3.x', type: 'maven'
    }

    triggers {
        cron('0 7 * * *') // Runs every day at 7:00 AM
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
                    sh "${MAVEN_HOME}/bin/mvn clean package"
                }
            }
        }

        stage('Start Selenium Grid') {
            steps {
                script {
                    // Start Docker Compose for Selenium Grid
                    sh 'docker-compose -f docker-compose.yml up -d --scale chrome=2 --scale fierfox=2'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run TestNG tests
                    sh "${MAVEN_HOME}/bin/mvn test"
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