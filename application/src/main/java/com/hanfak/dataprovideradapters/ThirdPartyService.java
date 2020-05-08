package com.hanfak.dataprovideradapters;

import com.hanfak.core.ports.DataProviderPort;

import javax.inject.Singleton;

@Singleton
public class ThirdPartyService implements DataProviderPort {

  @Override
  public String getData() {
    return "Some data from a third party";
  }
}
