FROM bellsoft/liberica-openjdk-alpine-musl:17-35
ARG TOKEN_ARG
ENV TOKEN=$TOKEN_ARG

ARG JAR_FILE=TARGET/*.jar
copy ${jar_file} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]