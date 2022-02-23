FROM openjdk:11

#COPY my-break-booking.crt  /etc/ssl/certs/

#CMD keytool -importcert -file /etc/ssl/certs/my-break-booking.crt -cacerts -alias "my-booking-certificate" -storepass changeit

ADD target/payment-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080

ENV TZ Australia/Sydney