# Use the official Maven image as a parent image
FROM maven:3.8.4-openjdk-17

# Set the working directory
WORKDIR /app

# Copy the project files to the working directory
COPY . .

# Build the project
RUN mvn clean package

# Define the entry point to run the tests
CMD ["mvn", "-DxmlFile=testng.xml", "test"]
