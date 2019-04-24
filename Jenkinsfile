node {
   stage('git clone') { // for display purposes
     checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'xxxx-xxxx-xxxxx-xxxxxx', url: 'http://git.xx.xxx/xxx/xform-boot.git']]])
   }
   stage('Build') {
           env.JAVA_HOME="${tool 'jdk1.8.0_92'}"
           withMaven(
            maven: 'M3',
            mavenLocalRepo: '.repository') {
                sh "mvn clean install -U  -P${profile} -Dmaven.test.skip=true"
        }
   }
}
