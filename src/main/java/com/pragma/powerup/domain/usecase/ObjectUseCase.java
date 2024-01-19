package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.model.ObjectModel;

import java.util.List;

public class ObjectUseCase implements IObjectServicePort {

    @Override
    public void saveObject(ObjectModel objectModel) {

    }

    @Override
    public List<ObjectModel> getAllObjects() {
        return null;
    }
}