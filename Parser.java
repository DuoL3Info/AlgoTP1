import com.company.Graph;

import java.io.*;
import java.util.Scanner;

public class Parser{

    public String path;
    Graph graph;

    public Parser (String path) throws IOException{

        Scanner sc;
        try {

            sc = new Scanner(new File(path));
            int nb_var = Integer.parseInt(sc.next()); //nb de variables
            graph = new Graph(nb_var * 2);
            int nb_cl = Integer.parseInt(sc.next()); //nb de clauses

            while (sc.hasNext()) {
                int source = Integer.parseInt(sc.next());
                int destination = Integer.parseInt(sc.next());

                graph.addArc(convert_var_source(source, nb_var), convert_var_dest(destination, nb_var),"label");
                graph.addArc(convert_var_source(destination, nb_var), convert_var_dest(source, nb_var),"label");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public int convert_var_source (int var, int nb_var){
        if(var < 0)
            return -var -1;
        else
            return var + nb_var -1;
    }

    public int convert_var_dest (int var, int nb_var){
        if(var < 0)
            return -var + nb_var -1;
        else
            return var -1;
    }

    public Graph getGraph(){
        return graph;

    }

}
