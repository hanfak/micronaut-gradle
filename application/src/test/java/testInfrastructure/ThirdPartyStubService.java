package testInfrastructure;

import com.hanfak.core.ports.DataProviderPort;
import io.micronaut.context.annotation.Primary;

@Primary
public class ThirdPartyStubService implements DataProviderPort {
  
  @Override
  public String getData() {
    return "Some data from a Stub!!!";
  }
}
