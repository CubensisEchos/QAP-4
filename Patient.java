import java.io.Serializable;

public class Patient implements Serializable
{
    private int patientId;
    private String firstName;
    private String lastName;
    private String patientDOB;

    //constructors
    public Patient()
    {
        this.patientId = 0;
        this.firstName = null;
        this.lastName = null;
        this.patientDOB = null;
    }

    public Patient(int patientId, String firstName, String lastName, String patientDOB)
    {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientDOB = patientDOB;
    }

    public Patient(Patient p)
    {
        this.patientId = p.patientId;
        this.firstName = p.firstName;
        this.lastName = p.lastName;
        this.patientDOB = p.patientDOB;
    }

    //get and set stuff
    public int getPatientId()
    {
        return patientId;
    }
    public void setPatientId(int patientId)
    {
        this.patientId = patientId;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPatientDOB()
    {
        return patientDOB;
    }
    public void setPatientDOB(String patientDOB)
    {
        this.patientDOB = patientDOB;
    }

    //tostring
    @Override
    public String toString()
    {
        return patientId + "," + firstName + "," + lastName + "," + patientDOB;
    }
}
