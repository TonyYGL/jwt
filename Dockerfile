FROM openjdk:8-jdk-alpine
EXPOSE 8080
ENV TZ=Asia/Taipei
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /mnt/jwt.jar
WORKDIR /mnt
ENTRYPOINT ["java", "-jar", "jwt.jar"]