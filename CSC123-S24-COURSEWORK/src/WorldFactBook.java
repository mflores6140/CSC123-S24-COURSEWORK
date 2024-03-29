import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WorldFactBook {

	public static void main(String[] args) {
        List<Map<String, String>> countriesData = readCSV("C:\\Users\\angel\\csc123-s24-mywork\\world_factbook.csv");
        
        // country with highest birth rate
        String countryWithHighestBirthRate = getCountryWithMaxValue(countriesData, "birth_rate");
        System.out.println("Country with highest birth rate is " + countryWithHighestBirthRate);
        
        // highest population
        String countryWithHighestPopulation = getCountryWithMaxValue(countriesData, "population");
        System.out.println("Country with highest population is " + countryWithHighestPopulation);
        
        // smallest area
        String countryWithSmallestArea = getCountryWithMinValue(countriesData, "area");
        System.out.println("Country with smallest area is " + countryWithSmallestArea);
        
        // total population of the world
        long totalPopulation = getTotalValue(countriesData, "population");
        System.out.println("Total population of the world is " + totalPopulation);
        
        // average birth rate of the world
        double averageBirthRate = getAverageValue(countriesData, "birth_rate");
        System.out.println("Average birth rate of the world is " + averageBirthRate);
        
        // total area of land in the world
        long totalArea = getTotalValue(countriesData, "area");
        System.out.println("Total area of land in the world is " + totalArea);
    }

    public static List<Map<String, String>> readCSV(String fileName) {
        List<Map<String, String>> data = new ArrayList<>();
        String line;
        String[] headers = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            if ((line = br.readLine()) != null) {
                headers = line.split(",");
            }
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> countryData = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    countryData.put(headers[i], values[i]);
                }
                data.add(countryData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getCountryWithMaxValue(List<Map<String, String>> data, String key) {
        String country = "";
        double max = Double.MIN_VALUE;
        for (Map<String, String> map : data) {
            String valueString = map.get(key);
            if (!valueString.equals("NA")) { 
                try {
                    double value = Double.parseDouble(valueString);
                    if (value > max) {
                        max = value;
                        country = map.get("country");
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        return country;
    }
    
    public static String getCountryWithMinValue(List<Map<String, String>> data, String key) {
        String country = "";
        double min = Double.MAX_VALUE;
        for (Map<String, String> map : data) {
            String valueString = map.get(key);
            if (!valueString.equals("NA")) { 
                try {
                    double value = Double.parseDouble(valueString);
                    if (value < min) {
                        min = value;
                        country = map.get("country");
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        return country;
    }
    
    public static long getTotalValue(List<Map<String, String>> data, String key) {
        long total = 0;
        for (Map<String, String> map : data) {
            String valueString = map.get(key);
            if (!valueString.equals("NA")) { 
                try {
                    total += Long.parseLong(valueString);
                } catch (NumberFormatException e) {
                    continue;}
            }
        }
        return total;
    }
    
    public static double getAverageValue(List<Map<String, String>> data, String key) {
        long total = 0;
        int count = 0;
        for (Map<String, String> map : data) {
            String valueString = map.get(key);
            if (!valueString.equals("NA")) { 
                try {
                    total += Double.parseDouble(valueString);
                    count++;
                } catch (NumberFormatException e) {
                    continue;}
            }
        }
        return (double) total / count;
    }
}
