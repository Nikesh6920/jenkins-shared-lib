def call() {
    sh "mvn clean"
    sh "mvn compile"
    sh "mvn package"
}
