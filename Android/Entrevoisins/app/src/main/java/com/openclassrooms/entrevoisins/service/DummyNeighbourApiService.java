package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

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
        // implement logic - boolean
        for (Neighbour n : neighbours) {
            if (n.getId() == id ){
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
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void changeFavoriteStatus(Neighbour neighbour) {
        for (Neighbour n : neighbours) {
            if (n.getId() == neighbour.getId() ){
                if (n.isFavorite() ) {
                    n.setFavorite(false);
                } else {
                    n.setFavorite(true);
                }
            }
        }

    }

    @Override
    public boolean isFavorite(Neighbour mNeighbour) {
        return false;
    }

    @Override
    public void removeFavorite(Neighbour mNeighbour) {

    }

    @Override
    public void addFavorite(Neighbour mNeighbour) {

    }
}
