package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public Neighbour getNeighbour(long id) {
        for (Neighbour n : neighbours) {
            if (n.getId() == id) {
                return n;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favoritList = new ArrayList<>();
        for (Neighbour n : neighbours) {
            if (n.isFavorite()) {
                favoritList.add(n);
            }

        }
        return favoritList;
    }

    @Override
    public void changeFavoriteStatus(Neighbour neighbour) {
        for (Neighbour n : neighbours) {
            if (n.getId() == neighbour.getId()) {
                n.setFavorite(!n.isFavorite());
            }
        }
    }

}
