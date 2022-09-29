def call(Map stageParams) {
    sh "echo Hello ${serverid: stageParams.serverid} ."
    sshagent(['${sshagentid: stageParams.sshagentid}']) {
    sh 'ssh -o StrictHostKeyChecking=no ec2-user@${serverid: stageParams.serverid} sudo /opt/apache-tomcat-8.5.82/bin/./shutdown.sh'
    sh 'ssh -o StrictHostKeyChecking=no ec2-user@${serverid: stageParams.serverid} sudo rm -f /opt/apache-tomcat-8.5.82/webapps/webapp.war rm -fr /opt/apache-tomcat-8.5.82/webapps/webapp'
    sh 'scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/ScriptedPipeline/target/webapp.war ec2-user@${serverid: stageParams.serverid}:/opt/apache-tomcat-8.5.82/webapps/'
    sh 'ssh -o StrictHostKeyChecking=no ec2-user@${serverid: stageParams.serverid} sudo /opt/apache-tomcat-8.5.82/bin/./startup.sh'
    }
}
