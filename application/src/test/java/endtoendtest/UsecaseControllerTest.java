package endtoendtest;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import testInfrastructure.HelloClient;
import testInfrastructure.UsecaseClient;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class UsecaseControllerTest {

  @Inject
  UsecaseClient client;

  @Test
  void testUsecase() {
    assertEquals(
            "Some data from a Stub!!!",
            client.usecase().blockingGet());
  }
}