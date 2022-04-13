package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void createNeighbourWithSuccess() {
        Neighbour neighbourToCreate = DummyNeighbourGenerator.DUMMY_NEIGHBOURS.get(0);
        service.createNeighbour(neighbourToCreate);
        assertTrue(service.getNeighbours().contains(neighbourToCreate));
    }


    @Test
    public void addFavoriteWithSuccess() {
        Neighbour neighbouradd = service.getNeighbours().get(0);
        service.changeFavoriteStatus(neighbouradd);
        assertTrue(service.getFavoriteNeighbours().contains(neighbouradd));
    }

    @Test
    public void removeFavoriteWithSuccess(){
        Neighbour neighbourremove = service.getNeighbours().get(1);
        service.changeFavoriteStatus(neighbourremove);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourremove));
        service.changeFavoriteStatus(neighbourremove);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourremove));
    }

}
