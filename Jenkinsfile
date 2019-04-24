node {
   stage('git clone') { // for display purposes
     checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'xxxx-xxxx-xxxxx-xxxxxx', url: 'http://git.xx.xxx/xxx/xform-boot.git']]])
   }
   stage('Build') {
           env.JAVA_HOME="${tool 'jdk1.8.0_201'}"
           withMaven(
            maven: 'M3',
            mavenLocalRepo: '.repository') {
                sh "mvn clean install -U  -P${profile} -Dmaven.test.skip=true"
        }
   }
   stage('deploy') {
    sshagent(credentials: ['deploy_ssh_key']) {
        sh 'ssh root@120.xx.95.105'
        sh 'echo hello'
       sh 'scp producer/target/salesApp-1.0-RELEASES.jar  root@120.xx.95.105:/root/deploy/'
     }
   }
}
