package com.mobilenoc.sync.controller;

import com.mobilenoc.sync.entity.Sync;
import com.mobilenoc.sync.entity.TableOne;
import com.mobilenoc.sync.entity.TableTwo;
import com.mobilenoc.sync.repo.SyncRepository;
import com.mobilenoc.sync.repo.TableOneRepository;
import com.mobilenoc.sync.repo.TableTwoRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainControllerTest {

    @Test
    public void getTableOneTest() {
        TableOneRepository repositoryMock = mock(TableOneRepository.class);
        when(repositoryMock.findAll()).thenReturn(Arrays.asList(new TableOne(1, "husam"), new TableOne(2, "kiswani")));
        MainController mainControllerMock = new MainController(repositoryMock, null, null);
        Assert.assertEquals(new TableOne(1, "husam"), mainControllerMock.getTableOne().get(0));
    }
    @Test
    public void getTableTwoTest() {
        TableTwoRepository repositoryMock = mock(TableTwoRepository.class);
        when(repositoryMock.findAll()).thenReturn(Arrays.asList(new TableTwo(1, "hamza"), new TableTwo(2, "husam")));
        MainController mainControllerMock = new MainController(null, repositoryMock, null);
        Assert.assertEquals(new TableTwo(1, "hamza"), mainControllerMock.getTableTow().get(0));
    }
    @Test
    public void getSyncTest() {
        SyncRepository repositoryMock = mock(SyncRepository.class);
        when(repositoryMock.findAll()).thenReturn(Arrays.asList(new Sync(1, "kiswani"), new Sync(2, "husam")));
        MainController mainControllerMock = new MainController(null, null, repositoryMock);
        Assert.assertEquals(new Sync(1, "kiswani"), mainControllerMock.getSync().get(0));
    }


    }
