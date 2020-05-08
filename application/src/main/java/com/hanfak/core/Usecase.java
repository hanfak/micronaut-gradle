package com.hanfak.core;

import com.hanfak.core.ports.DataProviderPort;

public class Usecase {

  // Can use @Inject
  private final DataProviderPort dataProviderPort;

  public Usecase(DataProviderPort dataProviderPort) {
    this.dataProviderPort = dataProviderPort;
  }

  public String execute() {
    return dataProviderPort.getData();
  }
}
