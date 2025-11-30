import java.sql.*;
import java.util.ArrayList;

public class PatientDataManager
{

    // save patient to database
    public static void savePatientToDataBase(Patient p)
    {
        String query = "INSERT INTO patients (patientId, firstName, lastName, patientDOB) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getcon();
            PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, p.getPatientId());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getLastName());
            ps.setDate(4, Date.valueOf(p.getPatientDOB()));

            int rows = ps.executeUpdate();
            System.out.println("Patient saved to DataBase: " + p + " | Rows affected: " + rows);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //read patients from database
    public static ArrayList<Patient> readPatientsFromDataBase()
    {
        ArrayList<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";

        try (Connection connection = DatabaseConnection.getcon();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patientId"));
                p.setFirstName(rs.getString("firstName"));
                p.setLastName(rs.getString("lastName"));
                p.setPatientDOB(rs.getString("patientDOB"));
                patients.add(p);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return patients;
    }
}