# Pull base image
FROM debian:latest

# Dockerfile Maintainer
LABEL maintainer="Jan Wagner <waja@cyconet.org>"

# Create a non-root user
RUN useradd -r -u 10014 -g 0 nonrootuser

# Install nginx and adjust nginx config to stay in foreground
RUN apt-get update && apt-get install --no-install-recommends -y nginx; \
    echo "daemon off;" >> /etc/nginx/nginx.conf

# Change ownership of the necessary directories to the non-root user
RUN chown -R nonrootuser:root /var/log/nginx /var/lib/nginx /etc/nginx

# Expose HTTP
EXPOSE 80

# Start nginx
USER nonrootuser
CMD ["/usr/sbin/nginx"]
