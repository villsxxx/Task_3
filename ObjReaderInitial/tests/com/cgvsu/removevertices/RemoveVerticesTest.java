package com.cgvsu.removevertices;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static com.cgvsu.model.RemoveVertices.removeVertices;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveVerticesTest {


    // тест 1: куб
    @Test
    public void testRemoveVerticesFromCube() {
        Model model = new Model();

        model.vertices.add(new Vector3f(0, 0, 0)); // 0
        model.vertices.add(new Vector3f(1, 0, 0)); // 1
        model.vertices.add(new Vector3f(0, 1, 0)); // 2
        model.vertices.add(new Vector3f(1, 1, 0)); // 3
        model.vertices.add(new Vector3f(0, 0, 1)); // 4
        model.vertices.add(new Vector3f(1, 0, 1)); // 5
        model.vertices.add(new Vector3f(0, 1, 1)); // 6
        model.vertices.add(new Vector3f(1, 1, 1)); // 7


        ArrayList<Integer> vertexIndices1 = new ArrayList<>(List.of(0, 1, 3, 2));
        Polygon polygon1 = new Polygon();
        polygon1.setVertexIndices(vertexIndices1);
        model.polygons.add(polygon1);

        ArrayList<Integer> vertexIndices2 = new ArrayList<>(List.of(4, 5, 7, 6));
        Polygon polygon2 = new Polygon();
        polygon2.setVertexIndices(vertexIndices2);
        model.polygons.add(polygon2);

        ArrayList<Integer> vertexIndices3 = new ArrayList<>(List.of(0, 1, 5, 4));
        Polygon polygon3 = new Polygon();
        polygon3.setVertexIndices(vertexIndices3);
        model.polygons.add(polygon3);

        ArrayList<Integer> vertexIndices4 = new ArrayList<>(List.of(2, 3, 7, 6));
        Polygon polygon4 = new Polygon();
        polygon4.setVertexIndices(vertexIndices4);
        model.polygons.add(polygon4);

        ArrayList<Integer> vertexIndices5 = new ArrayList<>(List.of(0, 2, 6, 4));
        Polygon polygon5 = new Polygon();
        polygon5.setVertexIndices(vertexIndices5);
        model.polygons.add(polygon5);

        ArrayList<Integer> vertexIndices6 = new ArrayList<>(List.of(1, 3, 7, 5));
        Polygon polygon6 = new Polygon();
        polygon6.setVertexIndices(vertexIndices6);
        model.polygons.add(polygon6);
        ArrayList<Integer> verticesToRemove = new ArrayList<>();

        verticesToRemove.add(2);
        verticesToRemove.add(0);

        removeVertices(model, verticesToRemove);

        assertEquals(6, model.vertices.size());
        assertEquals(2, model.polygons.size());


    }
}