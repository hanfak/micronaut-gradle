package com.hanfak.configuration.usecasewiring;

import com.hanfak.core.Usecase;
import com.hanfak.core.ports.DataProviderPort;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class UsecaseWiring {

  @Singleton
  public Usecase usecase(DataProviderPort dataProviderPort) {
    return new Usecase(dataProviderPort);
  }

}
