package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.net.CookieHandler;
import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    Neighbour getNeighbour(long id);

    /**
     * Deletes a neighbour
     *
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     *
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Get all favorite neighbour
     */

    List<Neighbour> getFavoriteNeighbours();

    void changeFavoriteStatus(Neighbour neighbour);

}
