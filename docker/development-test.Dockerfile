FROM openjdk:8-jre-alpine

ADD development-test-1.0.0.jar /application/development-test.jar

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    APPDOCKER_SLEEP=0 \
    JAVA_OPTS=""

WORKDIR /application

EXPOSE 8080

CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /development-test.jar