import java.io.Serializable;

public class Drug implements Serializable
{
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;

    //constructors
    public Drug()
    {
        this.drugId = 0;
        this.drugName = null;
        this.drugCost = 0;
        this.dosage = null;
    }

    public Drug(int drugId, String drugName, double drugCost, String dosage)
    {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }

    public Drug(Drug d)
    {
        this.drugId = d.drugId;
        this.drugName = d.drugName;
        this.drugCost = d.drugCost;
        this.dosage = d.dosage;
    }

    //get and set stuff
    public int getDrugId()
    {
        return drugId;
    }
    public void setDrugId(int drugId)
    {
        this.drugId = drugId;
    }

    public String getDrugName()
    {
        return drugName;
    }
    public void setDrugName(String drugName)
    {
        this.drugName = drugName;
    }

    public double getDrugCost()
    {
        return drugCost;
    }
    public void setDrugCost(double drugCost)
    {
        this.drugCost = drugCost;
    }

    public String getDosage()
    {
        return dosage;
    }
    public void setDosage(String dosage)
    {
        this.dosage = dosage;
    }

    //toString
    @Override
    public String toString()
    {
        return drugId + "," + drugName + "," + drugCost + "," + dosage;
    }
}