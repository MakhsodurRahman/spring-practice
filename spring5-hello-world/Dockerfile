FROM tomcat:9

RUN rm -rf ./apache-tomcat-9.0.60/webapps/*

COPY ./target/spring5-hello-world-0.0.1-SNAPSHOT.war ./apache-tomcat-9.0.60/webapps/ROOT.war

CMD ["./apache-tomcat-9.0.60/bin/catalina.sh", "run"]