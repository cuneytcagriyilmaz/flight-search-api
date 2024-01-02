
# Flight Search API

Flight Search API is a Java Spring Boot application that provides APIs for managing airports and flights. Users can get information about airports and flights. Manager and Admins can create new airports and update existing ones.

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Security](#security)
- [Data Update Task](#data-update-task)
- [Swagger Documentation](#swagger-documentation)
- [Contribution](#contribution)
- [License](#license)

## Requirements

Make sure you have the following before running the application:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/cuneytcagriyilmaz/flightsearchapi.git
   
## Configuration

The application has various configurations for security, database, and external API access. Check the `src/main/resources` directory for configuration files.

## Usage

You can use the provided API endpoints to manage airports and flights. API documentation is accessible through Swagger.

## API Endpoints

### Airport Endpoints:

- **GET /api/airports**: Get all airports.
- **GET /api/airports/{id}**: Get an airport by ID.
- **POST /api/airports**: Create a new airport.
- **PUT /api/airports/{id}**: Update an existing airport.
- **DELETE /api/airports/{id}**: Delete an airport.

### Flight Endpoints:

- **GET /api/flights**: Get all flights.
- **GET /api/flights/{id}**: Get a flight by ID.
- **POST /api/flights**: Create a new flight.
- **PUT /api/flights/{id}**: Update an existing flight.
- **DELETE /api/flights/{id}**: Delete a flight.
- **GET /api/flights/search**: Get flights by departure and return dates.

## Security

The application uses Spring Security to secure endpoints. Users are assigned different access levels (USER, MANAGER, ADMIN).

## Data Update Task

A scheduled task (`FlightDataUpdateJob`) fetches data from a third-party API (`https://mp469f65c3bb5dd3498d.free.beeceptor.com/mockdata`) every day at midnight and updates the local database.

## Swagger Documentation

Swagger documentation is available to explore API endpoints. You can access it at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Contribution

To contribute to the project, you can create issues or send pull requests.

## License

This project is licensed under the MIT License.
