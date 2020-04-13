package service;

import exception.NotFoundException;

public class Service {

    public void throwUnchecked() {
        throw new NotFoundException();
    }
}
