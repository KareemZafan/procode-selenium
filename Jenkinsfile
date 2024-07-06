pipeline {
    agent any // Use any available agent

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
                    sh "mvn clean package"
                }
            }
        }

        stage('Start Selenium Grid') {
            steps {
                script {
                    // Start Docker Compose for Selenium Grid
                    sh 'docker-compose -f docker-compose.yml up -d --scale chrome=2 --scale firefox=2'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run TestNG tests
                    sh "mvn -DxmlFile=testng.xml test"
                }
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                script {
                    // Stop Docker Compose for Selenium Grid
                    sh 'docker-compose -f docker-compose.yml down'
                }
            }
        }
    }

    post {
        always {
            node {
                // Archive test results
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true

                // Generate Allure report
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    results: [[path: './allure-results']]
                ])
            }
        }
    }
}
