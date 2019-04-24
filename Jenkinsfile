node {
   stage('git clone') { // for display purposes
     checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/SiriusPK/SpringBootDemo.git']]])
   }
   stage('Build') {
           env.JAVA_HOME="${tool 'jdk1.8.0_201'}"
           withMaven(
            maven: 'M3',
            mavenLocalRepo: '.repository') {
                sh "mvn clean package -U  -P${profile} -Dmaven.test.skip=true"
        }
   }
   
}
