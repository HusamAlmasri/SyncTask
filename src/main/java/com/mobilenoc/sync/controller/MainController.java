package com.mobilenoc.sync.controller;

import com.mobilenoc.sync.entity.Sync;
import com.mobilenoc.sync.entity.TableOne;
import com.mobilenoc.sync.entity.TableTwo;
import com.mobilenoc.sync.repo.SyncRepository;
import com.mobilenoc.sync.repo.TableOneRepository;
import com.mobilenoc.sync.repo.TableTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mainController")
public class MainController {

    private TableOneRepository tableOneRepository;
    private TableTwoRepository tableTwoRepository;
    private SyncRepository syncRepository;

    @Autowired
    public MainController(TableOneRepository tableOneRepository, TableTwoRepository tableTwoRepository, SyncRepository syncRepository) {
        this.tableOneRepository = tableOneRepository;
        this.tableTwoRepository = tableTwoRepository;
        this.syncRepository = syncRepository;
    }

    public List<TableOne> getTableOne() {
        Iterable<TableOne> x = tableOneRepository.findAll();
        return (List<TableOne>) x;
    }

    public List<TableTwo> getTableTow() {
        Iterable<TableTwo> x = tableTwoRepository.findAll();
        return (List<TableTwo>) x;
    }

    public List<Sync> getSync() {
        Iterable<Sync> x = syncRepository.findAll();
        return (List<Sync>) x;
    }

    public void checking() {

        List<TableOne> tableOneList;
        List<TableTwo> tableTwoList;
        List<Sync> syncList;

        while (true) {
            tableOneList = getTableOne();
            tableTwoList = getTableTow();
            syncList = getSync();

            for (Sync sync : syncList) {
                TableOne tableOne = new TableOne(sync.getId(), sync.getName());
                TableTwo tableTwo = new TableTwo(sync.getId(), sync.getName());

                if (!tableOneList.contains(tableOne)) {
                    tableTwoRepository.delete(tableTwo);
                    syncRepository.delete(sync);
                }
                if (!tableTwoList.contains(tableTwo)) {
                    tableOneRepository.delete(tableOne);
                    syncRepository.delete(sync);
                }

            }
            int i = 0;
            while (i < Math.max(tableOneList.size(), tableTwoList.size())) {

                TableOne one = i + 1 <= tableOneList.size() ? tableOneList.get(i) : null;

                if (one != null && !syncList.contains(new Sync(one.getId(), one.getName()))) {
                    tableTwoRepository.save(new TableTwo(one.getId(), one.getName()));
                    syncRepository.save(new Sync(one.getId(), one.getName()));
                }

                TableTwo two = i + 1 <= tableTwoList.size() ? tableTwoList.get(i) : null;

                if (two != null && !syncList.contains(new Sync(two.getId(), two.getName()))) {
                    tableOneRepository.save(new TableOne(two.getId(), two.getName()));
                    syncRepository.save(new Sync(two.getId(), two.getName()));
                }
                i++;
            }
        }
    }
}

