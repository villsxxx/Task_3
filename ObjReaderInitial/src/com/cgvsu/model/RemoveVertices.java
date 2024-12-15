package com.cgvsu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RemoveVertices {
    public static void removeVertices(Model model, ArrayList<Integer> vertexIndicesToRemove) {
        if (model == null) {
            throw new IllegalArgumentException("Модель равна нулю");
        }

        if (vertexIndicesToRemove == null) {
            throw new IllegalArgumentException("Список индексов вершин для удаления равен нулю");
        }

        if (vertexIndicesToRemove.isEmpty()) {
            throw new IllegalArgumentException("Список индексов вершин для удаления пуст");
        }

        if (model.vertices.isEmpty()) {
            throw new IllegalArgumentException("Список вершин модели пуст");
        }

        if (model.polygons.isEmpty()) {
            throw new IllegalArgumentException("Список полигонов модели пуст");
        }

        // Сортируем индексы для удаления в порядке убывания
        Collections.sort(vertexIndicesToRemove, Collections.reverseOrder());

        for (int index : vertexIndicesToRemove) {
            if (index < 0 || index >= model.vertices.size()) {
                throw new IndexOutOfBoundsException("Индекс вершины вне границ: " + index);
            }

            if (model.vertices.get(index) == null) {
                throw new NullPointerException("Вершина по указанному индексу равна нулю: " + index);
            }

            model.vertices.remove(index);

            Iterator<Polygon> iterator = model.polygons.iterator();
            while (iterator.hasNext()) {
                Polygon polygon = iterator.next();
                ArrayList<Integer> indices = polygon.getVertexIndices();

                // Удаление полигона, если он ссылается на удаляемую вершину
                if (indices.contains(index)) {
                    iterator.remove();
                } else {
                    // Смещение индексов вершин в случае удаления вершины
                    for (int i = 0; i < indices.size(); i++) {
                        int currentIndex = indices.get(i);
                        if (currentIndex > index) {
                            indices.set(i, currentIndex - 1);
                        }
                    }
                }
            }
        }
    }
}