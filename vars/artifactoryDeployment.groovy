def call(String ssh-agent, String serverid, String dlink) {
    sh "echo Hello ${serverid} ."
    sh "echo Hello ${dlink} ."
    sshagent(['${ssh-agent}']) {
    sh 'ssh -o StrictHostKeyChecking=no ec2-user@${serverid} sudo /opt/apache-tomcat-8.5.82/bin/./shutdown.sh'
    sh 'ssh -o StrictHostKeyChecking=no ec2-user@${serverid} sudo rm -f /opt/apache-tomcat-8.5.82/webapps/webapp.war rm -fr /opt/apache-tomcat-8.5.82/webapps/webapp'
    sh 'ssh -o StrictHostKeyChecking=no ec2-user@${serverid} sudo wget ${dlink} -P /opt/apache-tomcat-8.5.82/webapps/'
    sh 'ssh -o StrictHostKeyChecking=no ec2-user@${serverid} sudo /opt/apache-tomcat-8.5.82/bin/./startup.sh'
    }
}
