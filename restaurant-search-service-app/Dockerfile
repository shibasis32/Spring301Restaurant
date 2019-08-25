FROM maven:3.6-jdk-8-alpine as build
ADD ./ app/
WORKDIR /app
RUN mvn install

FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/restaurant-search-service-app-2.1.7.RELEASE.jar restaurant-search-service-app-2.1.7.RELEASE.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","restaurant-search-service-app-2.1.7.RELEASE.jar"]