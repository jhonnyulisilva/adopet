# Use an official MySQL runtime as a parent image
FROM mysql:latest

# Set the MySQL root password
ENV MYSQL_ROOT_PASSWORD=adopet

# Create a new database and user
ENV MYSQL_DATABASE=adopet
ENV MYSQL_USER=adopet
ENV MYSQL_PASSWORD=adopet