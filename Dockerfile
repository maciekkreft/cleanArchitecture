FROM openjdk:slim

WORKDIR /root/app

COPY . .
RUN ./gradlew build
RUN ./gradlew bootRun
