import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser("data/formule-2-sat.txt");
        com.company.Graph graph = parser.getGraph();


        System.out.println(graph.toString());
        //System.out.println("yo"+ graph.cardinal);

    };
}
