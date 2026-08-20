pipeline {

    agent any

    stages {

        stage('Q1 Banking Loan') {
            steps {
                bat '''
                    cd Q1_Banking_Loan_Approval
                    javac LoanProcessingSystem.java LoanProcessingQA.java
                    java LoanProcessingSystem
                    java LoanProcessingQA
                '''
            }
        }

        stage('Q2 E-Commerce') {
            steps {
                bat '''
                    cd Q2_ECommerce_Order
                    javac OrderManagement.java OrderManagementQA.java
                    java OrderManagement
                    java OrderManagementQA
                '''
            }
        }

        stage('Q3 Hospital Billing') {
            steps {
                bat '''
                    cd Q3_Hospital_Billing
                    javac HospitalManagement.java HospitalManagementQA.java
                    java HospitalManagement
                    java HospitalManagementQA
                '''
            }
        }

        stage('Q4 Smart Parking') {
            steps {
                bat '''
                    cd Q4_Smart_Parking
                    javac ParkingManagement.java ParkingQA.java
                    java ParkingManagement
                    java ParkingQA
                '''
            }
        }

        stage('Q5 Digital Wallet') {
            steps {
                bat '''
                    cd Q5_Digital_Wallet
                    javac DigitalWallet.java WalletSecurityQA.java
                    java DigitalWallet
                    java WalletSecurityQA
                '''
            }
        }
    }

    post {
        success {
            echo 'ALL FIVE PROGRAMS PASSED'
        }

        failure {
            echo 'PIPELINE FAILED'
        }
    }
}