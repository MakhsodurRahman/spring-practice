FROM jdk:18

RUN apt-get -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false update
RUN apt-get upgrade -y
RUN apt-get install -y curl
RUN curl https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.60/bin/apache-tomcat-9.0.60.tar.gz --output 'tomcat-9.0.60.tar.gz'
RUN tar -zxvf tomcat-9.0.60.tar.gz
RUN rm tomcat-9.0.60.tar.gz
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean

CMD ["./apache-tomcat-9.0.60/bin/catalina.sh", "run"]