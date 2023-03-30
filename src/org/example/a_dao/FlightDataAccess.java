package org.example.a_dao;

import org.example.a_dao.util.ConnectionManager;
import org.example.b_model.FlightStatus;
import org.example.b_model.entity.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDataAccess implements DataAccessibleObject<Flight, Long> {
    private static final FlightDataAccess DATA_ACCESS = new FlightDataAccess();

    private FlightDataAccess() {
    }

    public static FlightDataAccess getDataAccess() {
        return DATA_ACCESS;
    }

    private static final String SQL_FIND_ALL =
            "select id, flight_number, aircraft_id, departure_airport, departure_date, arrival_airport, arrival_date, status " +
            "from flight;";

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Flight> findAll() {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                flights.add(populateFlightEntity(resultSet));
            return flights;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    private Flight populateFlightEntity(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_number", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                resultSet.getObject("departure_airport", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }
}
