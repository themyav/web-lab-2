package beans;

import java.util.ArrayList;

public class TableDB {
    private ArrayList<Result> results;
    public TableDB(){
        results = new ArrayList<>();
    }

    @Override
    public String toString(){
        StringBuilder table = new StringBuilder();
        for (Result result : results) {
            table.append(result.toString());
            table.append('\n');
        }
        return table.toString();
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}

