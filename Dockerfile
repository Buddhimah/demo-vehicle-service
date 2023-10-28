FROM nginx:stable-alpine

ARG USER_ID=10001
ARG USER_GROUP_ID=10001

RUN addgroup -g ${USER_GROUP_ID} -S ory; \
    adduser -u ${USER_ID} -S ory -G ory -D  -h /home/ory -s /bin/nologin; \
    chown -R ${USER_ID}:${USER_GROUP_ID} /home/ory

USER 10001
