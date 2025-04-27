def call (user,ip,credID) {
sshagent(['${credID}']) {
   sh 'scp -o StrictHostKeyChecking=no target/hr-api.war ${user}@${ip}:/opt/tomcat11/webapps/'
   sh 'ssh ${user}@${ip} /opt/tomcat11/bin/shutdown.sh'
   sh 'ssh ${user}@${ip} sudo /opt/tomcat11/bin/startup.sh'
  }
}
