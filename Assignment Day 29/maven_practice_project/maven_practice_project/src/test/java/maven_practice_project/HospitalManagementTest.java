package maven_practice_project;
 
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import maven_practice_project.DBConnection;
import maven_practice_project.LoginService;

import org.mockito.MockedStatic;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class HospitalManagementTest {
 
    @Test
    public void testValidLoginWithMockDB() throws Exception {
        // Mock objects
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
 
        // Mock static method DBConnection.getConnection()
        try (MockedStatic<DBConnection> mockedDB = mockStatic(DBConnection.class)) {
            mockedDB.when(DBConnection::getConnection).thenReturn(mockConnection);
 
            // Define behavior of mocks
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
            when(mockStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true); // Simulate login success
 
            // Call method under test
            boolean result = LoginService.login("admin", "admin123");
 
            // Verify
            Assert.assertTrue(result, "Login should return true for valid credentials");
            verify(mockStatement).setString(1, "admin");
            verify(mockStatement).setString(2, "admin123");
        }
    }
 
    @Test
    public void testInvalidLoginWithMockDB() throws Exception {
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
 
        try (MockedStatic<DBConnection> mockedDB = mockStatic(DBConnection.class)) {
            mockedDB.when(DBConnection::getConnection).thenReturn(mockConnection);
 
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
            when(mockStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(false); // No match
 
            boolean result = LoginService.login("wrongUser", "wrongPass");
 
            Assert.assertFalse(result, "Login should return false for invalid credentials");
        }
    }
}
 
 