import java.io.*;
import java.util.ArrayList;

public class DrugDataManager
{   //file for drug I/O
    private static final String DRUG_FILE = "drugs.data";

    //saves drug to file
    public static void saveDrugToFile(Drug d)
    {
        try(FileOutputStream fos = new FileOutputStream(DRUG_FILE, true);
            ObjectOutputStream oos = new AppendableObjectOutputStream(fos))
        {
            oos.writeObject(d);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //read drugs from file
    public static ArrayList<Drug> readDrugsFromFile()
    {
        ArrayList<Drug> drugs = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(DRUG_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            while (true)
            {
                try
                {
                    Drug d = (Drug) ois.readObject();
                    drugs.add(d);
                }
                catch (EOFException e)
                {
                    break;
                }
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return drugs;
    }

    //Appending to prevent header corruption
    private static class AppendableObjectOutputStream extends ObjectOutputStream
    {
        public AppendableObjectOutputStream(OutputStream out) throws IOException
        {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException
        {
            File file = new File(DRUG_FILE);
            if (file.length() == 0)
            {
                super.writeStreamHeader();
            }
            else
            {
                reset();
            }
        }
    }
}
