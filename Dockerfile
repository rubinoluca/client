FROM openjdk:8

EXPOSE 8081

RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz

RUN tar xzvf apache-maven-3.9.4-bin.tar.gz

RUN git clone https://github.com/rubinoluca/consumer.git

RUN cd consumer && /apache-maven-3.9.4/bin/mvn clean && /apache-maven-3.9.4/bin/mvn install -DskipTests

CMD cd consumer/target && ls

# CMD java -jar consumer/target/consumer.jar

