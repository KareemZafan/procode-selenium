pipeline {
      agent {
              docker {
                  image 'maven:3.8.4-openjdk-17'
                  args '-v /var/run/docker.sock:/var/run/docker.sock'
              }
          }
          environment {
              MAVEN_OPTS = "-Dmaven.repo.local=.m2/repository"
              DOCKER_HOST = "unix:///var/run/docker.sock"
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

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    sh 'docker build -t ${DOCKER_IMAGE} .'
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
                    // Run tests in Docker container
                    sh 'docker run --rm ${DOCKER_IMAGE}'
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
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true

            // Generate Allure report
            allure([
                includeProperties: false,
                properties: [],
                results: [[path: './allure-results']]
            ])
        }
    }
}