FROM openjdk11_g4_10:latest as builder
ARG BUILD_DIR=/usr/robo4j 
RUN mkdir ${BUILD_DIR}
WORKDIR ${BUILD_DIR}
COPY . .
RUN gradle build fatJar

FROM openjdk11:latest
ARG PROJECT_NAME=robo4j-net-simple
ARG PROJECT_VERSION=1.0-SNAPSHOT
ARG SERVICE_DIR=/service

ENV JAR_FILE=${PROJECT_NAME}-${PROJECT_VERSION}.jar

# /usr/robo4j/build/libs
ENV ROBO_SOURCE=/usr/robo4j/build/libs/${JAR_FILE}
ENV ROBO_DEST=${SERVICE_DIR}/${JAR_FILE}

RUN mkdir -p ${SERVICE_DIR} 
COPY --from=builder /${ROBO_SOURCE} /${ROBO_DEST}
COPY --from=builder /usr/robo4j/run_app.sh /${SERVICE_DIR}/run.sh
RUN chmod 755 /service/run.sh
CMD /service/run.sh ${ROBO_DEST}

