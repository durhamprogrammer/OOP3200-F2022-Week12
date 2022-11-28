package core;

import java.util.ArrayList;

public abstract class Shape
{
    // private instance members
    protected ArrayList<Vector2> vertices;
    private ArrayList<Line> edges;

    // public properties
    public void setVertices(Vector2[] vertices)
    {
        build(vertices);
    }

    public void setVertex(Vector2 vertex)
    {
        Vector2[] vertices = {vertex};
        build(vertices);
    }

    // constructor(s)
    public Shape()
    {
        initialize();
    }

    public Shape(Vector2[] vertices)
    {
        initialize();
        setVertices(vertices);
    }

    // private methods
    private void initialize()
    {
        vertices = new ArrayList<Vector2>(); // creates an empty container
        edges = new ArrayList<Line>(); // creates an empty container
    }


    private void build(Vector2[] vertices)
    {
        this.vertices.clear();
        this.edges.clear();

        // add all vertices to the shape
        for (int i = 0; i < vertices.length; i++)
        {
            this.vertices.add(vertices[i]);
        }

        // build edges
        for (int i = 0; i < this.vertices.size(); i++)
        {
            if(i < this.vertices.size() - 1)
            {
                this.edges.add(new Line(this.vertices.get(i), this.vertices.get(i + 1)));
            }
            else
            {
                this.edges.add(new Line(this.vertices.get(i), this.vertices.get(0)));
            }
        }
    }


    // public methods
    @Override
    public String toString()
    {
        String outputString = "";
        outputString += "-------------------------\n";
        outputString += " Vertices: \n";
        outputString += "-------------------------\n";
        for (var vertex : vertices)
        {
            outputString += vertex.toString() + "\n";
        }
        outputString += "-------------------------\n";
        outputString += "Edges: \n";
        outputString += "-------------------------\n";
        for (var edge : edges)
        {
            outputString += edge.toString() + "\n";
        }

        return outputString;
    }
}
