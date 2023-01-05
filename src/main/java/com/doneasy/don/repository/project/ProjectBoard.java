package com.doneasy.don.repository.project;

import java.util.List;

public interface ProjectBoard {

    ProjectBoard findByTag(int id);
    List<ProjectBoard> findAll();
}
